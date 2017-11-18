package io.github.amarcinkowski

import groovy.util.logging.Slf4j

/**
 * Created by am on 15.11.17.
 */
@Slf4j
class Board {

    def squares = new Square[64]
    List<Piece> pieces = []

    def createBoard() {
        char col = 'a'
        for (int i = 0; i < 64; i += 8) {
            for (int j = 0; j < 8; j++) {
                squares[i + j] = new Square(column: col, row: j + 1)
            }
            col++;
        }
    }

    def addPieces() {
        pieces = Arrangment.getPieces()
    }

    Board() {
        createBoard()
        addPieces()
    }

    @Override
    String toString() {
        // group by 8 elements jointed by new line / replace null with NONE
        pieces.collate(8)*.join(' ').reverse().join('\n')
    }
}
