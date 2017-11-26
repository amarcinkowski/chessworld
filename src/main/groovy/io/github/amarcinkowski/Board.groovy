package io.github.amarcinkowski

import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Slf4j
@ToString
class Board implements Serializable {

    private final squares
    private final List<Piece> pieces = []

    Board() {
        pieces = Arrangment.getPieces()
        squares = Square1.values() //Arrangment.getSquares()
    }

    Piece getPiece(Square1 sq) {
        pieces.get(sq.ordinal())
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
