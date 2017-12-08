package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.board.Figure
import io.github.amarcinkowski.chess.board.Square
import io.github.amarcinkowski.chess.board.notation.BoardNotation

import io.github.amarcinkowski.chess.message.Message
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class BoardNotationSpec extends Specification {

    @Unroll
    def "Board read from #language should be read properly"() {
        given:
        Message.language(language + "-" + country.toUpperCase())
        def board = BoardNotation.valueOf(loaded)
        expect:
        log.debug "\n${board}"
        assert board.toString() == loaded
        assert board.getPiece(Square.C3).type == Figure.KNIGHT
        where:
        language | country | loaded
        'en'     | 'US'    | "r n b q k b _ r\n" +
                "p p p p p p p p\n" +
                "_ _ _ _ _ n _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ N _ _ _ _ _\n" +
                "P P P P P P P P\n" +
                "R _ B Q K B N R"
        'pl'     | 'PL'    | "w s g h k g _ w\n" +
                "p p p _ p p p p\n" +
                "_ _ _ p _ s _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ P _ _ _\n" +
                "_ _ S _ _ _ _ _\n" +
                "P P P P _ P P P\n" +
                "W _ G H K G S W"
        'es'     | 'ES'    | "t c a d r a _ t\n" +
                "p p p _ p p p p\n" +
                "_ _ _ p _ c _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ P _ _ _\n" +
                "_ _ C _ _ _ _ _\n" +
                "P P P P _ P P P\n" +
                "T _ A D R A C T"
        'eo'     | 'EO'    | "♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜\n" +
                "♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ♘ ∅ ∅ ∅ ∅ ∅\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙\n" +
                "♖ ∅ ♗ ♕ ♔ ♗ ♘ ♖"
    }
}
