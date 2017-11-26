package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import static Math.*

@Slf4j
enum Direction {

    NW(-1, 1), N(0, 1), NE(1, 1),

    W(-1, 0), /*     */ E(1, 0), //

    SW(-1, -1), S(0, -1), SE(1, -1)

    public int xstep
    public int ystep

    private Direction(int xstep, int ystep) {
        this.xstep = xstep
        this.ystep = ystep
    }

}
