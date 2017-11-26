package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.PAWN;
import static io.github.amarcinkowski.Direction.*;
import static io.github.amarcinkowski.Color.*;


@Slf4j
class Move {

    Board board
    Square from
    Square to

    int[] move(from, to) {
        int direction = board.getPiece(from).color.direction
        [to.x - from.x, (to.y - from.y) * direction]
    }

    boolean isValid() {
        def p = board.getPiece(from)
        def t = board.getPiece(to)
        def direction = CoordinateUtil.direction(from, to)

        p?.type == PAWN && (
                // 1-forward
                move(from, to) == [0, 1] && ( t == null || t?.type == PieceType.NULL) // means square 'to' on the board doesn't have a type, so it's empty
                        // 2-forward from row 2
                        || move(from, to) == [0, 2] && from.y == p.color.pawnRow // can go by 2 forward from 2 for white and 7 for black
                        // 1-diagonal with capture
                        || (p?.color == WHITE && (direction == NW || direction == NE) && t?.color == BLACK)
                        || (p?.color == BLACK && (direction == SE || direction == SW) && t?.color == WHITE)//
        )
    }
}
