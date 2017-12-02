package io.github.amarcinkowski.chess.board.notation

import io.github.amarcinkowski.Message
import io.github.amarcinkowski.chess.board.Piece
import io.github.amarcinkowski.chess.board.PieceType

class PieceNotation extends Notation<Piece> {

    @Override
    static Piece valueOf(String notation) {
        String key = Message.byValue(notation)
        def tokens = key.toUpperCase().tokenize('\\.')
        if (tokens.size() != 2) {
            return null
        }
        new Piece(type: PieceType.valueOf(tokens.get(1)), color: tokens.get(0))
    }

    @Override
    static String toString(Piece piece) {
        return piece.toString()
    }
}
