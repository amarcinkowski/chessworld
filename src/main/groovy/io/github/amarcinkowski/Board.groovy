package io.github.amarcinkowski

import groovy.util.logging.Slf4j

@Slf4j
class Board implements Serializable {

    private final List<Piece> pieces = []

    /**
     * init board with pieces starting position
     */
    Board() {
        pieces = Arrangment.getPieces()
    }

    /**
     * read board from notation string
     * @param notation
     */
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
        pieces.collate(8)*.join(' ').reverse().join('\n').replaceAll('null', Message.get('none'))
    }

}
