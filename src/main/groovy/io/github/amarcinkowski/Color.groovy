package io.github.amarcinkowski

enum Color {
    BLACK('b', -1, 7), WHITE('w', +1, 2), NULL('null', 0, 0)

    private final String notation
    public final int direction
    public final int pawnRow

    public Color(String notation, int direction, int pawnRow) {
        this.notation = notation
        this.direction = direction
        this.pawnRow = pawnRow
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
