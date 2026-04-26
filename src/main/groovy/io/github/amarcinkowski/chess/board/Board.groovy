package io.github.amarcinkowski.chess.board

import groovy.transform.builder.Builder
import groovy.transform.builder.DefaultStrategy
import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.board.notation.BoardNotation

@Slf4j
@Builder(builderStrategy = DefaultStrategy)
class Board {

    // TODO should be final with just capture / position change
    List<Piece> pieces = []

    /**
     * init board with pieces starting position
     */
    Board() {
        // Create a new list from the template to avoid mutating a shared static state
        pieces = new ArrayList<>(Arrangment.getPieces())
    }

    Piece getPiece(Square sq) {
        pieces.get(sq.ordinal())
    }

    void setPiece(Square sq, Piece piece) {
        pieces.set(sq.ordinal(), piece)
    }

    void applyMove(Square from, Square to) {
        Piece piece = getPiece(from)
        setPiece(to, piece)
        setPiece(from, null)
    }

    @Override
    String toString() {
        // TODO default notation / selected notation etc.
        BoardNotation.toString(this)
    }

}
