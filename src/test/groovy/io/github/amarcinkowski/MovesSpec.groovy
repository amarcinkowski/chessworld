package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

import static io.github.amarcinkowski.PieceType.*;

@Slf4j
class MovesSpec extends Specification {

    @Unroll
    def "move #from #to is valid: #valid"() {
        given:
        def board = new Board()
        def piece = board.getPiece(Square1.valueOf(from.toUpperCase()))
        log.info "$piece $from $to" // TODO pgn? algebraic notation "$pieceWithoutPawns$to"
        expect:
        assert new Move(board: board, from: Square1.valueOf(from), to: Square1.valueOf(to)).isValid() == valid
        where:
        from | to   | valid
        'B2' | 'B3' | true
        'C2' | 'C3' | true
        'C2' | 'C4' | true
        'B2' | 'B4' | true
        'B3' | 'B2' | false
        'A1' | 'A3' | false
        'A3' | 'A5' | false
        'B1' | 'C1' | false
        'B1' | 'D3' | false

    }
}
