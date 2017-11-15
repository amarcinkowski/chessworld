package io.github.amarcinkowski

/**
 * Created by am on 15.11.17.
 */
class Square {
    Character column
    Integer row

    Integer getOrdinal() {
        return ((int)column - (int)'a') * 8 + row
    }

    @Override
    String toString() {
        return "[" + column + row + "]-" + getOrdinal()
    }
}
