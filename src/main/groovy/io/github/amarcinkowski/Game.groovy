package io.github.amarcinkowski

/**
 * Created by am on 15.11.17.
 */
class Game {
    Player white
    Player black
    Board board = new Board()
    boolean whiteNext = true

    Game() {
        println board
    }

    public static void main(String[] args) {
        new Game()
    }

}
