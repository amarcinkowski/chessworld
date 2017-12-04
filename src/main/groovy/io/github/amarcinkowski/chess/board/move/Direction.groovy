package io.github.amarcinkowski.chess.board.move

import groovy.util.logging.Slf4j
import static java.lang.Math.*

@Slf4j
enum Direction {

      NNW(-0.5, 1),  NNE(0.5, 1),    

    NW(-1, 1), N(0, 1), NE(1, 1),

NWW(-1, 0.5),               NEE(1, 0.5),

    W(-1, 0), /*  x  */ E(1, 0), //

SWW(-1, -0.5),              SEE(1, -0.5),
    
    SW(-1, -1), S(0, -1), SE(1, -1),

      SSW(-0.5,-1),   SSE(0.5,-1)

    public float xstep
    public float ystep

    private Direction(float xstep, float ystep) {
        this.xstep = xstep
        this.ystep = ystep
    }

}
