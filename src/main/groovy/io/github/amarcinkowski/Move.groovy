package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.*

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

    private boolean isInPawnDirection(DirectionType directionType) {
        def p = board.getPiece(from)
        def key = p?.color.toString().toUpperCase() + "_" + directionType
        def direction = CoordinateUtil.direction(from, to)
        DirectionType.valueOf(key).directions.contains(direction)
    }

    private boolean isInDirection(DirectionType[] directionTypes) {
        if (is(PAWN)) {
            return isInPawnDirection(directionTypes.first())
        }
        def direction = CoordinateUtil.direction(from, to)
        def directions = directionTypes.collect { it.directions }.sum()
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
                isInDirection(DirectionType.FORWARD) && distance(1) && empty()
                        || isInDirection(DirectionType.FORWARD) && distance(2) && from.y == p.color.pawnRow // can go by 2 forward from 2 for white and 7 for black
                        || (isInDirection(DirectionType.FORWARD_DIAGONAL) && capture() && distance(1))
        ) ||
                is(ROOK) && (
                isInDirection(DirectionType.HORIZONTAL, DirectionType.VERTICAL)
                        && clearWay(steps)
                        && emptyOrCapture()
        ) ||
                is(KNIGHT) && (
                isInDirection(DirectionType.KNIGHT_JUMP)
                        && emptyOrCapture()
        ) || is(BISHOP) && (
                isInDirection(DirectionType.DIAGONAL)
                        && clearWay(steps)
                        && emptyOrCapture()
        ) || is(KING)
    }
}
