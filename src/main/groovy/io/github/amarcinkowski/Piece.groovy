package io.github.amarcinkowski

import groovy.transform.AutoClone
import groovy.util.logging.Slf4j

/**
 * Created by am on 15.11.17.
 */

@Slf4j
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
        def key = "$type"
        if (color) {
            key += ".$color"
        }

        Message.get(key)
    }

}
