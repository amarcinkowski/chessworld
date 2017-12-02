package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.board.utils.CoordinateUtil
import spock.lang.Specification
import spock.lang.Unroll

import static io.github.amarcinkowski.chess.board.Direction.*

@Slf4j
class DirectionSpec extends Specification {

    @Unroll
    def "#from - #to is #direction"() {
        expect:
        log.debug "$from -> $to = $direction"
        assert CoordinateUtil.direction(Square.valueOf(from), Square.valueOf(to)) == direction
        assert CoordinateUtil.step(Square.valueOf(from), Square.valueOf(to)) == step
        where:
        from | to   | direction | step
        'E5' | 'E6' | N         | 1
        'E5' | 'E4' | S         | 1
        'E5' | 'F5' | E         | 1
        'E5' | 'D5' | W         | 1
        'E5' | 'F6' | NE        | 1
        'E5' | 'F4' | SE        | 1
        'E5' | 'D6' | NW        | 1
        'E5' | 'D4' | SW        | 1
        // KNIGHT MOVES:
        'E5' | 'F7' | NNE       | 1
        'E5' | 'G6' | NEE       | 1
        'E5' | 'D7' | NNW       | 1
        'E5' | 'C6' | NWW       | 1
        'E5' | 'F3' | SSE       | 1
        'E5' | 'G4' | SEE       | 1
        'E5' | 'D3' | SSW       | 1
        'E5' | 'C4' | SWW       | 1
    }

    @Unroll
    def "Square #a1 by #x #y"() {
        expect:
        assert Square.byXY(x, y) == Square.valueOf(a1)
        where:
        x | y | a1
        1 | 1 | 'A1'
        8 | 1 | 'H1'
        1 | 2 | 'A2'
        8 | 8 | 'H8'
    }

    @Unroll
    def "Step #step in the #direction direction from E5 will take us to #to"() {
        expect:
        def sq = Square.valueOf(from)
        assert sq.to(direction, step) == Square.valueOf(to)
        where:
        from | direction | step | to
        'E5' | N         | 1    | 'E6'
        'E5' | W         | 2    | 'C5'
        'E5' | S         | 3    | 'E2'
        'E5' | E         | 3    | 'H5'
        'E5' | NE        | 2    | 'G7'
        'E5' | NW        | 3    | 'B8'
        'E5' | SE        | 2    | 'G3'
        'E5' | SW        | 4    | 'A1'
        // knight
        'E5' | NNE       | 1    | 'F7'
        'E5' | NEE       | 1    | 'G6'
        'E5' | NNW       | 1    | 'D7'
        'E5' | NWW       | 1    | 'C6'
        'E5' | SSE       | 1    | 'F3'
        'E5' | SEE       | 1    | 'G4'
        'E5' | SSW       | 1    | 'D3'
        'E5' | SWW       | 1    | 'C4'
    }

}
