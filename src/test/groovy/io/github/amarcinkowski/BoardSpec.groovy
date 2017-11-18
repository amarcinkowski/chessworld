package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import org.slf4j.LoggerFactory
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
        def board = new Board()
        Board.locale = new Locale(language.toLowerCase(), language.toUpperCase())
        log.info "\n${board}"
        expect:

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
                "R N B Q K B N R\n"
        'pl'     | "w s g h k g s w\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "W S G H K G S W\n"
        'eo'     | "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖\n"
    }
}
