package io.github.amarcinkowski

enum Color {
    BLACK(-1, 7), WHITE(+1, 2), NONE(0, 0) // TODO remove color none (pieceType null)

    public final int direction
    public final int pawnRow

    public Color(int direction, int pawnRow) {
        this.direction = direction
        this.pawnRow = pawnRow
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
