package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.PAWN;

@Slf4j
class Move {

    Board board
    Square from
    Square to

    int[] moveCoordinate(from, to) {
        int direction = board.getPiece(from).color.direction
        [to.x - from.x, (to.y - from.y) * direction]
    }

    boolean isValid() {
        def p = board.getPiece(from)

        p?.type == PAWN && (
                // 1-forward
                moveCoordinate(from, to) == [0, 1]
                        // 2-forward from row 2
                        || moveCoordinate(from, to) == [0, 2] && from.y == p.color.pawnRow)
        // 1-diagonal with capture
//        ||
    }
}
