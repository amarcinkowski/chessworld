package io.github.amarcinkowski

/**
 *
 U+2654	♔	e2 99 94	WHITE CHESS KING
 U+2655	♕	e2 99 95	WHITE CHESS QUEEN
 U+2656	♖	e2 99 96	WHITE CHESS ROOK
 U+2657	♗	e2 99 97	WHITE CHESS BISHOP
 U+2658	♘	e2 99 98	WHITE CHESS KNIGHT
 U+2659	♙	e2 99 99	WHITE CHESS PAWN
 U+265A	♚	e2 99 9a	BLACK CHESS KING
 U+265B	♛	e2 99 9b	BLACK CHESS QUEEN
 U+265C	♜	e2 99 9c	BLACK CHESS ROOK
 U+265D	♝	e2 99 9d	BLACK CHESS BISHOP
 U+265E	♞	e2 99 9e	BLACK CHESS KNIGHT
 U+265F	♟	e2 99 9f	BLACK CHESS PAWN
 U+2205 ∅               EMPTY
 */
public enum PieceType {
    KING('K'), ROOK('R'), BISHOP('B'), QUEEN('Q'), KNIGHT('N'), PAWN('P'), EMPTY('_')

    private PieceType(String notation) {
        this.notation = notation
    }
    private final String notation

    public final String notation() { Message.get("piece." + name().toLowerCase() + ".notation") }

}
