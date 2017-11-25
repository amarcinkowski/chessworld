package io.github.amarcinkowski

import groovy.transform.AutoClone
import groovy.util.logging.Slf4j

/**
 * Created by am on 15.11.17.
 */

@Slf4j
class Piece {
    Enum<PieceType> type
    Color color
    boolean captured

    static byNotation(Character notation) {
        def splitByDot = { it -> it?.contains(".") ?  it.split("\\.") : [it, "NULL"] }
        def getPieceType = { it -> PieceType.valueOf( splitByDot(it)[0].toString()?.toUpperCase()) }
        def getPieceColor = { it -> Color.valueOf( splitByDot(it)[1]?.toString()?.toUpperCase()) }
        def pieceByName = { it -> new Piece(type: getPieceType(it), color: getPieceColor(it)) }
        String key = Message.byValue(Game.language() + notation)
        def piece = pieceByName(key)
        log.trace "$notation -> $key -> $piece"
        piece
    }

    @Override
    String toString() {
        Message.get("${type}", "${color}")
    }

}
