package io.github.amarcinkowski

enum Color {
    BLACK(7), WHITE(2)

    public final int pawnRow

    public Color(int pawnRow) {
        this.pawnRow = pawnRow
    }

    static opposite(Color c1, Color c2) {
        c1 == BLACK && c2 == WHITE || c1 == WHITE && c2 == BLACK
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
