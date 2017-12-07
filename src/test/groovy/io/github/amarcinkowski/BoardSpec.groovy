package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.board.Board
import io.github.amarcinkowski.chess.message.Message
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class BoardSpec extends Specification {

    @Unroll
    def "Board should look like this in #language notation"() {
        given:
        Message.language(language + "-" + country)
        def board = new Board()
        expect:
        log.info "\n${language}\n${board}"
        assert board.toString() == expected
        where:
        language | country | expected
        'en'     | 'US'    | "r n b q k b n r\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "R N B Q K B N R"
        'pl'     | 'PL'    | "w s g h k g s w\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "W S G H K G S W"
        'eo'     | 'EO'    | "♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖"
    }

}
