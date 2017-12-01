package io.github.amarcinkowski

import static io.github.amarcinkowski.Direction.*

enum Color {
    BLACK(S, [SW, SE], 7), WHITE(N, [NW, NE], 2)

    public final Direction forward
    public final List<Direction> forwardDiagonal
    public final int pawnRow

    public Color(Direction forward, List<Direction> fotwardDiagonal, int pawnRow) {
        this.forward = forward
        this.forwardDiagonal = fotwardDiagonal
        this.pawnRow = pawnRow
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
