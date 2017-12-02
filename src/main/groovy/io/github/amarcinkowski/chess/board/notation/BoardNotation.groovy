package io.github.amarcinkowski.chess.board.notation

import io.github.amarcinkowski.chess.board.Square
import io.github.amarcinkowski.chess.message.Message
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

    static replaceNullWithColor = { it, index -> it == null ? (Square.squareColorByIndex(index) == 0 ? "\u25A0" : "\u25A1") : it }
    static replaceNullWithNoneChar = { it -> it == null ? Message.get('none') : it }

    @Override
    static String toString(Board board) {
        // TODO add e.g. @annotation for different notations STRATEGY
        board.pieces.withIndex().collect(replaceNullWithColor).collate(8)*.join(' ').reverse().join('\n')
        board.pieces.collect(replaceNullWithNoneChar).collate(8)*.join(' ').reverse().join('\n')
    }
}
