package io.github.amarcinkowski

import static Color.*

class Arrangment {

    final static List<Piece> pieces = []

    static {
        pieces.add(new Piece(type: PieceType.ROOK, color: WHITE))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: WHITE))
        pieces.add(new Piece(type: PieceType.BISHOP, color: WHITE))
        pieces.add(new Piece(type: PieceType.QUEEN, color: WHITE))
        pieces.add(new Piece(type: PieceType.KING, color: WHITE))
        pieces.add(new Piece(type: PieceType.BISHOP, color: WHITE))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: WHITE))
        pieces.add(new Piece(type: PieceType.ROOK, color: WHITE))
        8.times {
            pieces.add(new Piece(type: PieceType.PAWN, color: WHITE))
        }
        32.times {
            pieces.add(new Piece(type: PieceType.NONE))
        }
        8.times {
            pieces.add(new Piece(type: PieceType.PAWN, color: BLACK))
        }
        pieces.add(new Piece(type: PieceType.ROOK, color: BLACK))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: BLACK))
        pieces.add(new Piece(type: PieceType.BISHOP, color: BLACK))
        pieces.add(new Piece(type: PieceType.QUEEN, color: BLACK))
        pieces.add(new Piece(type: PieceType.KING, color: BLACK))
        pieces.add(new Piece(type: PieceType.BISHOP, color: BLACK))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: BLACK))
        pieces.add(new Piece(type: PieceType.ROOK, color: BLACK))

    }
}
