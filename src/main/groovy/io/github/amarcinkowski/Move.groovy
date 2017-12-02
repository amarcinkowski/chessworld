package io.github.amarcinkowski

import groovy.transform.builder.Builder
import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.*
import static io.github.amarcinkowski.DirectionType.*

@Slf4j
@Builder(includes = "board, from, to")
class Move {

    Board board
    Square from
    Square to

    def getDirection() {
        CoordinateUtil.direction(from, to)
    }

    def getStep() {
        CoordinateUtil.step(from, to)
    }

    def getSteps() {
        from.path(direction, step)
    }

    def getMovedPiece() {
        board.getPiece(from)
    }

    def getTargetPiece() {
        board.getPiece(to)
    }

    private boolean clearWay() {
        int emptySquaresOnPath = 0
        steps.each { if (board.getPiece(Square.valueOf(it)) == null) emptySquaresOnPath++ }
        steps.size() == emptySquaresOnPath
    }

    private boolean capture() {
        Piece.opposite(movedPiece, targetPiece)
    }

    private boolean emptyOrCapture() {
        empty() || capture()
    }

    private boolean empty() {
        targetPiece == null
    }

    private boolean isInPawnDirection(DirectionType directionType) {
        def key = movedPiece?.color.toString().toUpperCase() + "_" + directionType
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

    private boolean isPawnRow() {
        def p = board.getPiece(from)
        from.y == p.color.pawnRow
    }

    boolean isValid() {
        is(PAWN) && (
                isInDirection(FORWARD) && distance(1) && empty()
                        || isInDirection(FORWARD) && distance(2) && isPawnRow()
                        || (isInDirection(FORWARD_DIAGONAL) && capture() && distance(1))
        ) || is(ROOK) && (
                isInDirection(HORIZONTAL, VERTICAL)
                        && clearWay()
                        && emptyOrCapture()
        ) || is(KNIGHT) && (
                isInDirection(KNIGHT_JUMP)
                        && emptyOrCapture()
        ) || is(BISHOP) && (
                isInDirection(DIAGONAL)
                        && clearWay()
                        && emptyOrCapture()
        ) || is(KING) && (
                isInDirection(HORIZONTAL, VERTICAL, DIAGONAL)
                        && emptyOrCapture()
        )
    }
}
