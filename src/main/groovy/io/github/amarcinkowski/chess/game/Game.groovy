package io.github.amarcinkowski.chess.game

import io.github.amarcinkowski.chess.message.Language
import io.github.amarcinkowski.chess.message.Message
import io.github.amarcinkowski.chess.board.Board

class Game {

    Player white
    Player black
    Board board
    boolean whiteNext = true

    Game() {
        Message.language(Language.DEFAULT.toString())
        board = new Board()
    }

    public static void main(String[] args) {
        new Game()
    }

}
