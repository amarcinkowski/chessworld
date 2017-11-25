package io.github.amarcinkowski

/**
 * Created by am on 15.11.17.
 */
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
