package io.github.amarcinkowski.chess.board.move

import groovy.transform.builder.Builder
import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.board.Board
import io.github.amarcinkowski.chess.board.Figure
import io.github.amarcinkowski.chess.board.Side
import io.github.amarcinkowski.chess.board.Square
import io.github.amarcinkowski.chess.board.utils.CoordinateUtil

import static DirectionType.*

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

    def getIntermediateSquares() {
        from.path(direction, step)
    }

    def getMovedPiece() {
        board.getPiece(from)
    }

    def getTargetPiece() {
        board.getPiece(to)
    }

    private int getClearSquaresCount() {
        int emptySquaresOnPath = 0
        intermediateSquares.each { if (board.getPiece(Square.valueOf(it)) == null) emptySquaresOnPath++ }
        emptySquaresOnPath
    }

    private boolean isClearWay() {
        getIntermediateSquares().size() == getClearSquaresCount()
    }

    private boolean isCapture() {
        Side.opposite(getMovedPiece()?.color, getTargetPiece()?.color)
    }

    private boolean isEmptyOrCapture() {
        isEmpty() || isCapture()
    }

    private boolean isEmpty() {
        getTargetPiece() == null
    }

    private boolean isInPawnDirection(DirectionType directionType) {
        directionType.byColor(getMovedPiece()?.color).directions.contains(getDirection())
    }

    private boolean isInDirection(DirectionType[] directionTypes) {
        directionTypes.collect { it.directions }.sum().contains(getDirection())
    }

    private boolean is(Figure type) {
        getMovedPiece()?.type == type
    }

    private boolean distance(int stepSize) {
        getStep() == stepSize
    }

    private boolean isFromPawnRow() {
        from.y == getMovedPiece()?.color.pawnRow
    }

    // TODO isInDirection -> validDirection() in Figure / Figure
    private boolean isForward() {
        isInPawnDirection(FORWARD)
    }

    private boolean isForwardDiagonal() {
        isInPawnDirection(FORWARD_DIAGONAL)
    }

    private boolean isJump() {
        isInDirection(KNIGHT_JUMP)
    }

    private boolean isHorizontalOrVertical() {
        isInDirection(HORIZONTAL, VERTICAL)
    }

    private boolean isHorizontalVerticalDiagonal() {
        isInDirection(HORIZONTAL, VERTICAL, DIAGONAL)
    }

    private boolean isDiagonal() {
        isInDirection(DIAGONAL)
    }

    private boolean isPawn() {
        is(Figure.PAWN)
    }

    private boolean isRook() {
        is(Figure.ROOK)
    }

    private boolean isKnight() {
        is(Figure.KNIGHT)
    }

    private boolean isBishop() {
        is(Figure.BISHOP)
    }

    private boolean isKing() {
        is(Figure.KING)
    }

    private boolean isQueen() {
        is(Figure.QUEEN)
    }

    private boolean isShortDistance() {
        distance(1)
    }

    private boolean isDoubleShortDistance() {
        distance(2)
    }

    private boolean isOneStepForward() {
        isForward() && isShortDistance() && isEmpty()
    }

    private boolean isTwoStepForward() {
        isForward() && isDoubleShortDistance() && isFromPawnRow() && isClearWay() && isEmpty()
    }

    private boolean isPawnCapture() {
        isForwardDiagonal() && isShortDistance() && isCapture()
    }

    private boolean isPawnMove() {
        isPawn() && (isOneStepForward() || isTwoStepForward() || isPawnCapture())
    }

    private boolean isRookMove() {
        isRook() && isHorizontalOrVertical() && isClearWay() && isEmptyOrCapture()
    }

    private boolean isKnightMove() {
        isKnight() && isJump() && isEmptyOrCapture()
    }

    private boolean isBishopMove() {
        isBishop() && isDiagonal() && isClearWay() && isEmptyOrCapture()
    }

    private boolean isKingMove() {
        isKing() && isHorizontalVerticalDiagonal() && isShortDistance() && isEmptyOrCapture()
    }

    private boolean isQueenMove() {
        isQueen() && isHorizontalVerticalDiagonal() && isClearWay() && isEmptyOrCapture()
    }

    boolean isValid() {
        isPawnMove() || isRookMove() || isKnightMove() || isBishopMove() || isKingMove() || isQueenMove()
    }
}
