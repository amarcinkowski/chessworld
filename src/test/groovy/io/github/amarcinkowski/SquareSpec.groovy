package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class SquareSpec extends Specification {

    @Unroll
    def "Square #n should convert to #x,#y"() {
        expect:
        log.debug "Square $n -> $x, $y"
        def square = Square.find { it.n == n }
        assert [x, y] == [square.x, square.y]
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
        log.debug "Square $x, $y -> $n"
        def square = Square.find { it.n == n }
        assert square.x == x && square.y == y
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
        log.debug "Square $a1 -> $n"
        assert n == Square.valueOf(a1).n
        where:
        n  | a1
        1  | 'A1'
        2  | 'B1'
        3  | 'C1'
        8  | 'H1'
        9  | 'A2'
        17 | 'A3'
        16 | 'H2'
        64 | 'H8'
    }
}
