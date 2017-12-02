package io.github.amarcinkowski

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
