package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import static io.github.amarcinkowski.PieceType.PAWN;

@Slf4j
class Move {

    Board board
    Square1 from
    Square1 to

    int[] moveCoordinate(from, to) {
        return [to.x - from.x, to.y - from.y]
    }

    boolean isValid() {
        def p = board.getPiece(getFrom())

        p.type == PAWN && (
                // 1-forward
                moveCoordinate(from, to) == [0, 1]
                        // 2-forward from row 2
                        || moveCoordinate(from, to) == [0, 2] && from.y == 2)
        // 1-diagonal with capture
//        ||
    }
}
