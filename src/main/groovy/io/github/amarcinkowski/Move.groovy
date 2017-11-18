package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.*;

/**
 * Created by am on 17.11.17.
 */
@Slf4j
class Move {

    Board board
    Square from
    Square to

    int[] moveCoordinate(from, to) {
        return [to.x - from.x, to.y - from.y]
    }

    boolean isValid() {
        def p = board.getPiece(getFrom().getA1())

        p.type == PAWN && (
                // 1-forward
                moveCoordinate(from, to) == [1, 0]
                        // 2-forward from row 2
                        || moveCoordinate(from, to) == [2, 0] && from.row == 2)
        // 1-diagonal with capture
//        ||
    }
}