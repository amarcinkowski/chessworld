package io.github.amarcinkowski

import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Slf4j
@ToString
class Board implements Serializable {

    private final squares = new Square[64]
    private final List<Piece> pieces = []

    Board() {
        pieces = Arrangment.getPieces()
        squares = Arrangment.getSquares()
    }

    Piece getPiece(Square sq) {
        pieces.get(sq.n - 1)
    }

    // TODO BoardSerializer ?
    @Override
    String toString() {
        // group by 8 elements jointed by new line / replace null with NONE
        pieces.collate(8)*.join(' ').reverse().join('\n')
    }

    // TODO BoardBuilder ? BoardSerializer ?
    Board fromString(String board) {
        pieces.clear()
        char[] notation = board.replaceAll(' ', '').split('\n').reverse().join('').toCharArray()
        notation.each { pieces.add(Piece.byNotation(it)) }
        log.debug "Loaded: " + toString()
        this
    }


}
