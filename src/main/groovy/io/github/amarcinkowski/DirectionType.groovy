package io.github.amarcinkowski

import static io.github.amarcinkowski.Direction.*

enum DirectionType {
    VERTICAL([N, S]), HORIZONTAL([W, E]), DIAGONAL([NE, NW, SE, SW]),
    KNIGHT_JUMP([NNE, NEE, NNW, NWW, SWW, SSW, SEE, SSE]),
    PERPENDICULAR([N, S, W, E]), WHITE_FORWARD([N]),
    BLACK_FORWARD([S]), WHITE_FORWARD_DIAGONAL([NW, NE]),
    BLACK_FORWARD_DIAGONAL([SW, SE]),
    FORWARD([]), FORWARD_DIAGONAL([])

    final List<Direction> directions

    private DirectionType(List<Direction> directions) {
        this.directions = directions
    }
}
