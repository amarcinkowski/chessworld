package io.github.amarcinkowski

/**
 * Created by am on 15.11.17.
 */
public enum PieceType {
    KING('K'), ROOK('R'), BISHOP('B'), QUEEN('Q'), KNIGHT('N'), PAWN('P')

    private PieceType(String notation) {
        this.notation = notation
    }
    private final String notation
    public final String notation() {notation}
}
