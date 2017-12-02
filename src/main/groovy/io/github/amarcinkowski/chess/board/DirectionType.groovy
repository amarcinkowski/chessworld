package io.github.amarcinkowski.chess.board

import static Direction.*

enum DirectionType {
    BLACK_FORWARD_DIAGONAL([SW, SE]),
    BLACK_FORWARD([S]),
    DIAGONAL([NE, NW, SE, SW]),
    FORWARD_DIAGONAL([]),
    FORWARD([]),
    HORIZONTAL([W, E]),
    KNIGHT_JUMP([NNE, NEE, NNW, NWW, SWW, SSW, SEE, SSE]),
    PERPENDICULAR([N, S, W, E]), // FIXME USE?
    VERTICAL([N, S]),
    WHITE_FORWARD_DIAGONAL([NW, NE]),
    WHITE_FORWARD([N]),

    final List<Direction> directions

    final byColor(Color color) {
        DirectionType.valueOf(color.toString().toUpperCase() + "_" + this)
    }

    private DirectionType(List<Direction> directions) {
        this.directions = directions
    }
}
