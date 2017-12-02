package io.github.amarcinkowski.chess.board.notation

abstract class Notation<T> {
    static T valueOf(String notation) {}
    static String toString(T t) {}
}
