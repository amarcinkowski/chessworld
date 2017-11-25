package io.github.amarcinkowski

import static Color.*

class Arrangment {

    final static List<Piece> pieces = []
    final static squares = new Square[64]

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

        // a1 .. h8
        char col = 'a'
        for (int i = 0; i < 64; i += 8) {
            for (int j = 0; j < 8; j++) {
                squares[i + j] = new Square(column: col, row: j + 1)
            }
            col++;
        }
    }
}
