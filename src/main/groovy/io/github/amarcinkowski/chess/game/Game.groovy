package io.github.amarcinkowski.chess.game

import io.github.amarcinkowski.Language
import io.github.amarcinkowski.Message
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
