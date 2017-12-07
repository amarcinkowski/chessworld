package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.board.Board
import io.github.amarcinkowski.chess.board.move.Move
import io.github.amarcinkowski.chess.board.Square
import io.github.amarcinkowski.chess.board.notation.BoardNotation

import io.github.amarcinkowski.chess.message.Message
import spock.lang.Specification
import spock.lang.Unroll

@Slf4j
class MovesSpec extends Specification {

    @Unroll
    def "move #from #to is valid: #valid"() {
        given:
        Message.language('en-US')
        def board = new Board()
        log.debug "\n$board"
        expect:
        assert new Move(board: board, from: Square.valueOf(from), to: Square.valueOf(to)).isValid() == valid
        log.debug "from $from to $to is $valid"
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

    @Unroll
    def "with this game move #from #to is valid: #valid"() {
        given:
        Message.language('eo-EO')
        def init = "♜ ♞ ♝ ♛ ♚ ♝ ∅ ♜\n" +
                "∅ ♟ ♟ ♟ ∅ ♟ ♟ ♟\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ∅ ∅ ∅ ∅ ∅ ♙\n" +
                "∅ ∅ ∅ ♞ ∅ ∅ ∅ ∅\n" +
                "∅ ∅ ♘ ∅ ♟ ∅ ∅ ∅\n" +
                "♙ ♙ ♙ ♙ ♙ ♙ ♙ ∅\n" +
                "♖ ∅ ♗ ♕ ♔ ♗ ♘ ♖"
        def board = BoardNotation.valueOf(init)
        expect:
        log.debug "\n${board}"
        assert new Move(board: board, from: Square.valueOf(from), to: Square.valueOf(to)).isValid() == valid
        where:
        from | to   | valid
        // pawn
        'B2' | 'B3' | true
        'C2' | 'C3' | false // own figure
        'E2' | 'E3' | false // opposite figure
        'D2' | 'E3' | true
        'F2' | 'E3' | true
        'F2' | 'G3' | false // no capture
        // rook
        'H1' | 'H2' | true
        'H1' | 'H3' | true
        'H1' | 'H4' | true
        'H1' | 'H5' | false
        'H1' | 'H6' | false
        'A1' | 'B1' | true
        'A1' | 'C1' | false
        'A8' | 'A2' | true
        'H8' | 'H2' | false
        // knight
        'G1' | 'F3' | true
        'G1' | 'H3' | true
        'G1' | 'E2' | false // own pawn
        'G1' | 'E3' | false // wrong
        'D4' | 'C6' | true
        'D4' | 'E6' | true
        'D4' | 'B5' | true
        'D4' | 'F5' | true
        'D4' | 'B3' | true
        'D4' | 'C2' | true
        'D4' | 'E2' | true
        'D4' | 'F3' | true
        'D4' | 'D4' | false // no move
        'D4' | 'E4' | false // 1E
        'D4' | 'F4' | false // 2E
        'D4' | 'E5' | false // 1NE
        // bishop
        'F8' | 'E7' | true
        'F8' | 'D6' | true
        'F8' | 'G7' | false // own figure
        'F8' | 'G8' | false // 1E

    }
}
