package io.github.amarcinkowski

import groovy.transform.builder.Builder
import groovy.transform.builder.DefaultStrategy
import groovy.util.logging.Slf4j

@Slf4j
@Builder(builderStrategy = DefaultStrategy)
class Piece {
    Enum<PieceType> type
    Color color
    boolean captured

    static byNotation(Character notation) {
        String key = Message.byValue(notation)
        def tokens = key.toUpperCase().tokenize('\\.')
        def piece
        if (tokens.size() == 2) {
            piece = new Piece(type: PieceType.valueOf(tokens.get(1)), color: tokens.get(0))
        } else {
            piece = null
        }
        piece
    }

    static opposite(Piece p1, Piece p2) {
        p1 != null && p2 != null && (
                (p1.color == Color.BLACK && p2.color == Color.WHITE) ||
                        (p1.color == Color.WHITE && p2.color == Color.BLACK)
        )
    }

    @Override
    String toString() {
        Message.get("${color}", "${type}")
    }

}
