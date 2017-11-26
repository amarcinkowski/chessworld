package io.github.amarcinkowski

class CoordinateUtil {

    static int a2x(char c) {
        (int) c - (int) 'A' + 1
    }

    static char x2a(int x) {
        (char) ((int) 'A' + x - 1)
    }

    static int xy2n(int x, int y) {
        (y - 1) * 8 + x
    }

    static String[] possibleMoves(Direction direction, int x, int y) {
        def ret = []
        for (int stepSize in 1..7) {
            def newx = x + direction.xstep * stepSize
            def newy = y + direction.ystep * stepSize
            if (newx > 8 || newx < 1) break
            if (newy > 8 || newy < 1) break
            ret += "'${x2a(newx)}$newy'"
        }
        ret
    }

    static int normalize(int n) {
        n == 0 ? 0 : (n / n)
    }

    static Direction direction(Square from, Square to) {
        def x = CoordinateUtil.normalize(to.x - from.x)
        def y = CoordinateUtil.normalize(to.y - from.y)
        Direction.values().find { it -> x == it.xstep && y == it.ystep }
    }

    static int step(Square from, Square to) {
        Math.max(Math.abs(to.x - from.x), Math.abs(to.y - from.y))
    }
}
