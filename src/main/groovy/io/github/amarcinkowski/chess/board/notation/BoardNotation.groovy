package io.github.amarcinkowski.chess.board.notation

import io.github.amarcinkowski.Message
import io.github.amarcinkowski.chess.board.Piece
import io.github.amarcinkowski.chess.board.Board

class BoardNotation extends Notation<Board> {

    /**
     * read board from notation string
     * @param notation
     */
    @Override
    static Board valueOf(String notation) {
        def pieces = []
        notation.replaceAll(' ', '').split('\n').reverse().join('').toCharArray().each {
            pieces.add(Piece.byNotation(it))
        }
        new Board().builder().pieces(pieces).build()
    }

    /**
     *
     * @param index
     * @return 0 for black square / 1 for white
     */
    static everySecondEightSwitch(int index) {
        def p = index % 2
        def q = Math.floor(index / 8) % 2
        def np = (p + 1) % 2
        def nq = (q + 1) % 2
        def xor = Math.max(p * nq, q * np)
        xor
    }

    static replaceNullWithColor = { it, index -> it == null ? (everySecondEightSwitch(index) == 1 ? "\u25A0" : "\u25A1") : it }
    static replaceNullWithNoneChar = { it -> it == null ? Message.get('none') : it }

    @Override
    static String toString(Board board) {
        // TODO add e.g. @annotation for different notations
        board.pieces.withIndex().collect(replaceNullWithColor).collate(8)*.join(' ').reverse().join('\n')
        board.pieces.collect(replaceNullWithNoneChar).collate(8)*.join(' ').reverse().join('\n')
    }
}
