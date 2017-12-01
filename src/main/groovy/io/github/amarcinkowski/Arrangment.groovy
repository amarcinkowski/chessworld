package io.github.amarcinkowski

import static Color.*
import static io.github.amarcinkowski.PieceType.*

class Arrangment {

    final static List<Piece> pieces = []
    static white = {new Piece().builder().color(WHITE).type(PieceType.valueOf(it.toString().toUpperCase())).build()}
    static black = {new Piece().builder().color(BLACK).type(PieceType.valueOf(it.toString().toUpperCase())).build()}

    static {
        pieces.add(white(ROOK))
        pieces.add(white(KNIGHT))
        pieces.add(white(BISHOP))
        pieces.add(white(QUEEN))
        pieces.add(white(KING))
        pieces.add(white(BISHOP))
        pieces.add(white(KNIGHT))
        pieces.add(white(ROOK))
        8.times {
            pieces.add(new Piece(type: PAWN, color: WHITE))
        }
        32.times {
            pieces.add(null)
        }
        8.times {
            pieces.add(new Piece(type: PAWN, color: BLACK))
        }
        pieces.add(black(ROOK))
        pieces.add(black(KNIGHT))
        pieces.add(black(BISHOP))
        pieces.add(black(QUEEN))
        pieces.add(black(KING))
        pieces.add(black(BISHOP))
        pieces.add(black(KNIGHT))
        pieces.add(black(ROOK))

    }
}
