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

    static String[] inDirection(Direction direction, int x, int y) {
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
}
