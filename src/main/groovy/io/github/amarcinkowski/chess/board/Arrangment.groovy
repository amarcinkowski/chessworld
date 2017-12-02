package io.github.amarcinkowski.chess.board

import static Color.*

class Arrangment {

    final static List<Piece> pieces = []
    static white = {new Piece().builder().color(WHITE).type(Figure.valueOf(it.toString().toUpperCase())).build()}
    static black = {new Piece().builder().color(BLACK).type(Figure.valueOf(it.toString().toUpperCase())).build()}

    static {
        pieces.add(white(Figure.ROOK))
        pieces.add(white(Figure.KNIGHT))
        pieces.add(white(Figure.BISHOP))
        pieces.add(white(Figure.QUEEN))
        pieces.add(white(Figure.KING))
        pieces.add(white(Figure.BISHOP))
        pieces.add(white(Figure.KNIGHT))
        pieces.add(white(Figure.ROOK))
        8.times {
            pieces.add(new Piece(type: Figure.PAWN, color: WHITE))
        }
        32.times {
            pieces.add(null)
        }
        8.times {
            pieces.add(new Piece(type: Figure.PAWN, color: BLACK))
        }
        pieces.add(black(Figure.ROOK))
        pieces.add(black(Figure.KNIGHT))
        pieces.add(black(Figure.BISHOP))
        pieces.add(black(Figure.QUEEN))
        pieces.add(black(Figure.KING))
        pieces.add(black(Figure.BISHOP))
        pieces.add(black(Figure.KNIGHT))
        pieces.add(black(Figure.ROOK))

    }
}
