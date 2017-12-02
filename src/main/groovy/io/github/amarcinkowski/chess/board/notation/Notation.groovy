package io.github.amarcinkowski.chess.board.notation

/**
 * Created by am on 02.12.17.
 */
abstract class Notation<T> {
    static T valueOf(String notation) {}
    static String toString(T t) {}
}
