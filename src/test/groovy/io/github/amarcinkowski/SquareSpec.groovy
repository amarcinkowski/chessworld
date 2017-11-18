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

    @Unroll
    def "#a1  should convert to #n"() {
        expect:
        n == Square.a12n(a1)
        where:
        n  | a1
        1  | 'a1'
        2  | 'b1'
        3  | 'c1'
        8  | 'h1'
        9  | 'a2'
        17 | 'a3'
        16 | 'h2'
        64 | 'h8'
    }
}
