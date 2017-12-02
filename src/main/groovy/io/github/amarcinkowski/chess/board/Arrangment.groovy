package io.github.amarcinkowski.chess.board

import static Color.*

class Arrangment {

    final static List<Piece> pieces = []
    static white = {new Piece().builder().color(WHITE).type(PieceType.valueOf(it.toString().toUpperCase())).build()}
    static black = {new Piece().builder().color(BLACK).type(PieceType.valueOf(it.toString().toUpperCase())).build()}

    static {
        pieces.add(white(PieceType.ROOK))
        pieces.add(white(PieceType.KNIGHT))
        pieces.add(white(PieceType.BISHOP))
        pieces.add(white(PieceType.QUEEN))
        pieces.add(white(PieceType.KING))
        pieces.add(white(PieceType.BISHOP))
        pieces.add(white(PieceType.KNIGHT))
        pieces.add(white(PieceType.ROOK))
        8.times {
            pieces.add(new Piece(type: PieceType.PAWN, color: WHITE))
        }
        32.times {
            pieces.add(null)
        }
        8.times {
            pieces.add(new Piece(type: PieceType.PAWN, color: BLACK))
        }
        pieces.add(black(PieceType.ROOK))
        pieces.add(black(PieceType.KNIGHT))
        pieces.add(black(PieceType.BISHOP))
        pieces.add(black(PieceType.QUEEN))
        pieces.add(black(PieceType.KING))
        pieces.add(black(PieceType.BISHOP))
        pieces.add(black(PieceType.KNIGHT))
        pieces.add(black(PieceType.ROOK))

    }
}
