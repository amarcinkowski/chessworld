package io.github.amarcinkowski.chess.board

import groovy.transform.builder.Builder
import groovy.util.logging.Slf4j
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
        intermediateSquares.size() == clearSquaresCount
    }

    private boolean isCapture() {
        Color.opposite(movedPiece?.color, targetPiece?.color)
    }

    private boolean isEmptyOrCapture() {
        empty || capture
    }

    private boolean isEmpty() {
        targetPiece == null
    }

    private boolean isInPawnDirection(DirectionType directionType) {
        directionType.byColor(movedPiece?.color).directions.contains(direction)
    }

    private boolean isInDirection(DirectionType[] directionTypes) {
        directionTypes.collect { it.directions }.sum().contains(direction)
    }

    private boolean is(Figure type) {
        movedPiece?.type == type
    }

    private boolean distance(int stepSize) {
        step == stepSize
    }

    private boolean isFromPawnRow() {
        from.y == movedPiece?.color.pawnRow
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
        forward && shortDistance && empty
    }

    private boolean isTwoStepForward() {
        forward && doubleShortDistance && fromPawnRow && clearWay && empty
    }

    private boolean isPawnCapture() {
        forwardDiagonal && shortDistance && capture
    }

    private boolean isPawnMove() {
        pawn && (oneStepForward || twoStepForward || pawnCapture)
    }

    private boolean isRookMove() {
        rook && horizontalOrVertical && clearWay && emptyOrCapture
    }

    private boolean isKnightMove() {
        knight && jump && emptyOrCapture
    }

    private boolean isBishopMove() {
        bishop && diagonal && clearWay && emptyOrCapture
    }

    private boolean isKingMove() {
        king && horizontalVerticalDiagonal && shortDistance && emptyOrCapture
    }

    private boolean isQueenMove() {
        queen && horizontalVerticalDiagonal && clearWay && emptyOrCapture
    }

    boolean isValid() {
        pawnMove || rookMove || knightMove || bishopMove || kingMove || queenMove
    }
}
