package io.github.amarcinkowski.chess.board.utils

import io.github.amarcinkowski.chess.board.move.Direction

/**
 * Used to generate enum below
 */
class SquareEnumGenerator {

    private static String[] possibleMoves(Direction direction, int x, int y) {
        def ret = []
        for (int stepSize in 1..7) {
            if ([Direction.NNE, Direction.NNW, Direction.SSE, Direction.SSW, Direction.NEE, Direction.NWW, Direction.SEE, Direction.SWW].contains(direction)) {
                if (stepSize != 2) {
                    continue // leave only proper Knight moves
                }
            }
            def newx = x + direction.xstep * stepSize
            def newy = y + (int) (direction.ystep * stepSize)
            if (newx > 8 || newx < 1) break
            if (newy > 8 || newy < 1) break
            ret += "'${CoordinateUtil.x2a(newx)}$newy'"
        }
        ret
    }

    private static allDirections(int x, int y) {
        def s = ""
        for (Direction d : Direction.values()) {
            s += "\n\t\t$d:${possibleMoves(d, x, y)},"
        }
        s
    }

    public static void main(String[] args) {
        for (int y in 1..8) {
            for (int x in 1..8) {
                println """${CoordinateUtil.x2a(x)}${y} (${CoordinateUtil.xy2n(x, y)}, [$x,$y],
\t\t[ /* squares in directions from ${CoordinateUtil.x2a(x)}${y}*/${allDirections(x, y)}\n\t] as Map),
"""
            }
        }
    }
}
