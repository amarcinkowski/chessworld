package io.github.amarcinkowski

enum Color {
    BLACK(7), WHITE(2)

    public final int pawnRow

    public Color(int pawnRow) {
        this.pawnRow = pawnRow
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
