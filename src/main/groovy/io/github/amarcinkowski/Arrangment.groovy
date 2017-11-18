package io.github.amarcinkowski

import static Color.*

class Arrangment {

    final static List<Piece> pieces = []

    static {
        def i = 1
        pieces.add(new Piece(type: PieceType.ROOK, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.BISHOP, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.QUEEN, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.KING, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.BISHOP, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: WHITE, square: i++))
        pieces.add(new Piece(type: PieceType.ROOK, color: WHITE, square: i++))
        8.times {
            pieces.add(new Piece(type: PieceType.PAWN, color: WHITE, square: i++))
        }
        32.times {
            pieces.add(new Piece(type: PieceType.NONE))
        }
        8.times {
            pieces.add(new Piece(type: PieceType.PAWN, color: BLACK, square: i++))
        }
        pieces.add(new Piece(type: PieceType.ROOK, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.BISHOP, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.QUEEN, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.KING, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.BISHOP, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.KNIGHT, color: BLACK, square: i++))
        pieces.add(new Piece(type: PieceType.ROOK, color: BLACK, square: i))
    }
}
