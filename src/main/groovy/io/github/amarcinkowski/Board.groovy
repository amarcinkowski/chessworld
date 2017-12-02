package io.github.amarcinkowski

import groovy.transform.builder.Builder
import groovy.transform.builder.DefaultStrategy
import groovy.util.logging.Slf4j
import io.github.amarcinkowski.notation.BoardNotation

@Slf4j
@Builder(builderStrategy = DefaultStrategy)
class Board {

    // TODO should be final with just capture / position change
    List<Piece> pieces = []

    /**
     * init board with pieces starting position
     */
    Board() {
        pieces = Arrangment.getPieces()
    }

    Piece getPiece(Square sq) {
        pieces.get(sq.ordinal())
    }

    @Override
    String toString() {
        // TODO default notation / selected notation etc.
        BoardNotation.toString(this)
    }

}
