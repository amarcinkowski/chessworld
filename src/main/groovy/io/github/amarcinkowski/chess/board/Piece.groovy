package io.github.amarcinkowski.chess.board

import groovy.transform.builder.Builder
import groovy.transform.builder.DefaultStrategy
import groovy.util.logging.Slf4j
import io.github.amarcinkowski.Message

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

    @Override
    String toString() {
        Message.get("${color}", "${type}")
    }

}
