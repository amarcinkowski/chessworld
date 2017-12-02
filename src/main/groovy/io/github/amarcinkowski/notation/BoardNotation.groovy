package io.github.amarcinkowski.notation

import io.github.amarcinkowski.Message
import io.github.amarcinkowski.Piece
import io.github.amarcinkowski.Board

/**
 * Created by am on 02.12.17.
 */
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

    @Override
    static String toString(Board board) {
        board.pieces.collate(8)*.join(' ').reverse().join('\n').replaceAll('null', Message.get('none'))
    }
}
