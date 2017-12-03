package io.github.amarcinkowski.chess.board

import groovy.transform.builder.Builder
import groovy.transform.builder.DefaultStrategy
import groovy.util.logging.Slf4j
import io.github.amarcinkowski.chess.message.Message
import io.github.amarcinkowski.chess.board.notation.PieceNotation

@Slf4j
@Builder(builderStrategy = DefaultStrategy)
class Piece {
    Enum<Figure> type
    Side color
    boolean captured

    static byNotation(Character notation) {
        PieceNotation.valueOf(notation.toString())
    }

    @Override
    String toString() {
        Message.get("${color}", "${type}")
    }

}
