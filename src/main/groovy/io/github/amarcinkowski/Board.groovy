package io.github.amarcinkowski

/**
 * Created by am on 15.11.17.
 */
class Board {
    def squares = new Square[64]

    Board() {
        char col = 'a'
        for (int i = 0; i < 64; i += 8) {
            for (int j = 0; j < 8; j++) {
                squares[i + j] = new Square(column: col, row: j + 1 )
            }
            col++;
        }
    }

    @Override
    String toString() {
        return squares.join(', ')
    }
}
