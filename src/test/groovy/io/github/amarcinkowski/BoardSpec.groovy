package io.github.amarcinkowski

import groovy.json.JsonBuilder
import groovy.util.logging.Slf4j
import org.slf4j.LoggerFactory
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by am on 16.11.17.
 */
@Slf4j
class BoardSpec extends Specification {


    @Unroll
    def "Board should look like this in #language notation"() {
        given:
        Game.locale = new Locale(language.toLowerCase(), language.toUpperCase())
        def board = new Board()
        expect:
        log.info "\n${board}"
        assert board.toString() == expected
        where:
        language | expected
        'en'     | "r n b q k b n r\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "R N B Q K B N R"
        'pl'     | "w s g h k g s w\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "W S G H K G S W"
        'eo'     | "♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖"
    }

    @Unroll
    def "Board read from #language should be read properly"() {
        given:
        Game.locale = new Locale(language.toLowerCase(), language.toUpperCase())
        def board = new Board().fromString(loaded)
        expect:
        log.info "\n${board}"
        assert board.toString() == loaded
        assert board.getPiece('b1').type == PieceType.NONE
        assert board.getPiece('c3').type == PieceType.KNIGHT
        where:
        language | loaded
        'en'     | "r n b q k b _ r\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ n _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ N _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "R _ B Q K B N R"
        'pl'     | "w s g h k g _ w\n" +
                "p p p _ p p p p\n" +
                "_ _ _ p _ s _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ P _ _ _\n" +
                "_ _ S _ _ _ _ _\n" +
                "P P P P _ P P P\n" +
                "W _ G H K G S W"
        'eo'     | "♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ♘ ∅ ∅ ∅ ∅ ∅\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "♖ ∅ ♗ ♕ ♔ ♗ ♘ ♖"

    }
}
