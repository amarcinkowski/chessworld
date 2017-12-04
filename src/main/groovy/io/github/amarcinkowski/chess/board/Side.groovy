package io.github.amarcinkowski.chess.board

enum Side {
    BLACK(7), WHITE(2)

    public final int pawnRow

    public Side(int pawnRow) {
        this.pawnRow = pawnRow
    }

    static opposite(Side c1, Side c2) {
        c1 == BLACK && c2 == WHITE || c1 == WHITE && c2 == BLACK
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
