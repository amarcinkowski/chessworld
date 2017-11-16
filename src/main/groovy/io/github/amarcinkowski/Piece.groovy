package io.github.amarcinkowski

import groovy.transform.AutoClone

/**
 * Created by am on 15.11.17.
 */

@AutoClone
class Piece {
    Enum<PieceType> type
    Integer square
    Color color
    boolean captured

    def move(int x, int y) {
        int[] xy = Square.n2xy(square)
        xy[0] += x
        xy[1] += y
        square = Square.xy2n(xy[0], xy[1])
    }

    @Override
    String toString() {
        return color == Color.WHITE ? type.notation : type.notation.toLowerCase()
    }

}
