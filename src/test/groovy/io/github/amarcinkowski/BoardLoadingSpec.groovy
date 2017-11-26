package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class BoardLoadingSpec extends Specification {

    @Unroll
    def "Board read from #language should be read properly"() {
        given:
        Message.language(language)
        def board = new Board(loaded)
        expect:
        log.info "\n${board}"
        assert board.toString() == loaded
        assert board.getPiece(Square.C3).type == PieceType.KNIGHT
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
