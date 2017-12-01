package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.PAWN

@Slf4j
class Move {

    Board board
    Square from
    Square to

    private boolean capture() {
        def p = board.getPiece(from)
        def t = board.getPiece(to)
        Piece.opposite(p, t)
    }

    private boolean empty() {
        def t = board.getPiece(to)
        t == null
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
        def direction = CoordinateUtil.direction(from, to)

        is(PAWN) && (
                // 1-forward
                direction == p.color.forward && distance(1) && empty() // FIXME TODO direction == p.color.forward -> boolean movingForward(p) { }
                        || direction == p.color.forward && distance(2) && from.y == p.color.pawnRow // can go by 2 forward from 2 for white and 7 for black
                        || (p.color.forwardDiagonal.contains(direction) && capture() && distance(1))
        )
    }
}
