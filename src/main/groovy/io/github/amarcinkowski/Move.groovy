package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.*
import static io.github.amarcinkowski.Direction.*

@Slf4j
class Move {

    Board board
    Square from
    Square to

    private boolean clearWay(List<String> steps) {
        int emptySquaresOnPath = 0
        steps.each { if (board.getPiece(Square.valueOf(it)) == null) emptySquaresOnPath++ }
        steps.size() == emptySquaresOnPath
    }

    private boolean capture() {
        def p = board.getPiece(from)
        def t = board.getPiece(to)
        Piece.opposite(p, t)
    }

    private boolean emptyOrCapture() {
        empty() || capture()
    }

    private boolean empty() {
        def t = board.getPiece(to)
        t == null
    }

    private boolean isInDirection(Direction[] directions) { // use directionType ?
        def direction = CoordinateUtil.direction(from, to)
        directions.contains(direction)
    }

    private boolean is(PieceType type) {
        def p = board.getPiece(from)
        p?.type == type
    }

    private boolean distance(int stepSize) {
        def step = CoordinateUtil.step(from, to)
        step == stepSize
    }

    boolean isValid() {
        def p = board.getPiece(from)
        def t = board.getPiece(to)
        def direction = CoordinateUtil.direction(from, to)
        def step = CoordinateUtil.step(from, to)
        def steps = from.path(direction, step)

        is(PAWN) && (
                // 1-forward
                direction == p.color.forward && distance(1) && empty() // FIXME TODO direction == p.color.forward -> boolean movingForward(p) { }
                        || direction == p.color.forward && distance(2) && from.y == p.color.pawnRow // can go by 2 forward from 2 for white and 7 for black
                        || (p.color.forwardDiagonal.contains(direction) && capture() && distance(1))
        ) ||
                is(ROOK) && (
                isInDirection(N, W, S, E)
                        && clearWay(steps)
                        && emptyOrCapture()
        )
    }
}
