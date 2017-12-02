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

    private boolean isClearWay() {
        int emptySquaresOnPath = 0
        steps.each { if (board.getPiece(Square.valueOf(it)) == null) emptySquaresOnPath++ }
        steps.size() == emptySquaresOnPath
    }

    private boolean isCapture() {
        Piece.opposite(movedPiece, targetPiece)
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
        pawn ? isInPawnDirection(directionTypes.first())
                :
                directionTypes.collect { it.directions }.sum().contains(direction)
    }

    private boolean is(PieceType type) {
        movedPiece?.type == type
    }

    private boolean distance(int stepSize) {
        step == stepSize
    }

    private boolean isFromPawnRow() {
        from.y == movedPiece?.color.pawnRow
    }

    private boolean isForward() {
        isInDirection(FORWARD)
    }

    private boolean isForwardDiagonal() {
        isInDirection(FORWARD_DIAGONAL)
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
        is(PAWN)
    }

    private boolean isRook() {
        is(ROOK)
    }

    private boolean isKnight() {
        is(KNIGHT)
    }

    private boolean isBishop() {
        is(BISHOP)
    }

    private boolean isKing() {
        is(KING)
    }

    private boolean isQueen() {
        is(QUEEN)
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
