package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

import static io.github.amarcinkowski.PieceType.*;

/**
 * Created by am on 16.11.17.
 */
@Slf4j
class MovesSpec extends Specification {

    @Unroll
    def "move #from #to is valid: #valid"() {
        given:
        def board = new Board()
        def piece = board.getPiece(from)
        log.info "$piece"
        expect:
        assert new Move(board: board, from: new Square(a1: from), to: new Square(a1: to)).isValid() == valid
        where:
        from | to   | valid
        'b2' | 'b3' | true
        'c2' | 'c3' | true
        'b3' | 'b4' | true
        'b2' | 'b4' | true
        'b3' | 'b2' | false
        'a1' | 'a3' | false
        'b1' | 'c1' | false
        'b1' | 'd3' | false

    }
}
