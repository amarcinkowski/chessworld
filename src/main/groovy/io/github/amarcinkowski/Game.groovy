package io.github.amarcinkowski

class Game {
    static locale = Language.DEFAULT.locale()

    Player white
    Player black
    Board board = new Board()
    boolean whiteNext = true

    Game() {
        println board
    }

    static String language() {
        locale.getLanguage().toString()
    }

    public static void main(String[] args) {
        new Game()
    }

}
