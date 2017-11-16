package io.github.amarcinkowski

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by am on 16.11.17.
 */
class SquareSpec extends Specification {

    @Unroll
    def "#n should convert to #x,#y"() {
        expect:
        [x, y] == Square.n2xy(n)
        where:
        n  | x | y
        1  | 1 | 1
        2  | 2 | 1
        3  | 3 | 1
        8  | 8 | 1
        9  | 1 | 2
        10 | 2 | 2
        16 | 8 | 2
        17 | 1 | 3
        64 | 8 | 8
    }

    @Unroll
    def "#x,#y  should convert to #n"() {
        expect:
        n == Square.xy2n(x, y)
        where:
        n  | x | y
        1  | 1 | 1
        2  | 2 | 1
        3  | 3 | 1
        8  | 8 | 1
        9  | 1 | 2
        10 | 2 | 2
        16 | 8 | 2
        64 | 8 | 8
    }
}
