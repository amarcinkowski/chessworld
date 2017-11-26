package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class MovesSpec extends Specification {

    @Unroll
    def "move #from #to is valid: #valid"() {
        given:
        def board = new Board()
        def piece = board.getPiece(Square.valueOf(from.toUpperCase()))
        log.info "$piece $from $to" // TODO pgn? algebraic notation "$pieceWithoutPawns$to"
        expect:
        assert new Move(board: board, from: Square.valueOf(from), to: Square.valueOf(to)).isValid() == valid
        where:
        from | to   | valid
        // white
        'B2' | 'B3' | true
        'C2' | 'C3' | true
        'C2' | 'C4' | true
        'B2' | 'B4' | true
        'B3' | 'B2' | false
        'A1' | 'A3' | false
        'A3' | 'A5' | false
        'B1' | 'C1' | false
        'B1' | 'D3' | false
        'B2' | 'D5' | false
        // black
        'B7' | 'B6' | true
        'C7' | 'C6' | true
        'C7' | 'C5' | true
        'B7' | 'B5' | true
        'B7' | 'B8' | false
        'A8' | 'A6' | false
        'B7' | 'C7' | false
        'B7' | 'D7' | false

    }
}
