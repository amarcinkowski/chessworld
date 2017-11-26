package io.github.amarcinkowski

import groovy.transform.ToString
import groovy.util.logging.Slf4j

@Slf4j
@ToString
class Board implements Serializable {

    // rm squares?
    private final squares = Square.values()
    private final List<Piece> pieces = []

    Board() {
        pieces = Arrangment.getPieces()
    }

    Board(String notation) {
        notation.replaceAll(' ', '').split('\n').reverse().join('').toCharArray().each {
            pieces.add(Piece.byNotation(it))
        }
    }

    Piece getPiece(Square sq) {
        pieces.get(sq.ordinal())
    }

    @Override
    String toString() {
        // group by 8 elements jointed by new line / replace null with NONE
        pieces.collate(8)*.join(' ').reverse().join('\n')
    }

}
