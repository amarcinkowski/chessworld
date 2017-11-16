package io.github.amarcinkowski

/**
 * Created by am on 16.11.17.
 */
class Arrangment {

    final static pieces = []

    static {
        pieces.add(PieceType.ROOK)
        pieces.add(PieceType.KNIGHT)
        pieces.add(PieceType.BISHOP)
        pieces.add(PieceType.QUEEN)
        pieces.add(PieceType.KING)
        pieces.add(PieceType.BISHOP)
        pieces.add(PieceType.KNIGHT)
        pieces.add(PieceType.ROOK)
        8.times { pieces.add(PieceType.PAWN) }
    }
}
