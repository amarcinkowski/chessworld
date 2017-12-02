package io.github.amarcinkowski.chess.board.utils

import io.github.amarcinkowski.chess.board.Direction
import io.github.amarcinkowski.chess.board.Square

class CoordinateUtil {

    static int a2x(char c) {
        (int) c - (int) 'A' + 1
    }

    static char x2a(double x) {
        (char) ((int) 'A' + (int) (x - 1))
    }

    static int xy2n(int x, int y) {
        (y - 1) * 8 + x
    }

    static Direction direction(Square from, Square to) {
        def deltax = to.x - from.x
        def deltay = to.y - from.y
        def normal = Math.max(Math.abs(deltax), Math.abs(deltay))
        if (normal != 0) {
            deltax /= normal
            deltay /= normal
        }

        Direction.values().find { it -> deltax == it.xstep && deltay == it.ystep }
    }

    static int step(Square from, Square to) {
        def deltax = Math.abs(to.x - from.x)
        def deltay = Math.abs(to.y - from.y)
        if (deltax == 2 && deltay == 1 || deltay == 2 && deltax == 1) {
            return 1
        }
        if (deltax == deltay) {
            return deltax
        }
        Math.max(deltax, deltay)
    }
}
