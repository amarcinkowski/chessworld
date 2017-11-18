package io.github.amarcinkowski

import groovy.util.logging.Slf4j

import java.awt.Point

/**
 * Created by am on 15.11.17.
 */
@Slf4j
class Square {
    Character column
    Integer row

    Integer getOrdinal() {
        return ((int) column - (int) 'a') * 8 + row
    }

    void setA1(String a1) {
        this.column = a1.charAt(0)
        this.row = a1.charAt(1).toString().toInteger()
    }

    String getA1() {
        this.column.toString() + row.toString()
    }

    int[] getXY() {
        return [row, (int) column - (int) 'a']
    }

    int getX() {
        return row
    }

    int getY() {
        return (int) column - (int) 'a'
    }

    static int[] a12xy(String a1) {
        def column = a1.charAt(0)
        def row = a1.charAt(1).toString().toInteger()
        [row, (int) column - (int) 'a']
    }

    static int a12n(String a1) {
        def x = (int) a1.charAt(0) - (int) 'a' + 1
        def y = a1.charAt(1).toString().toInteger()
        log.info "$a1 $x $y"
        return x + (y - 1) * 8
    }


    static int[] n2xy(int n) {
        assert n > 0 && n < 65
        [n - 8 * Math.ceil(n / 8) + 8, Math.ceil(n / 8)]
    }

    // n = x + (y - 1) * 8
    // x = n - 8y +8
    // y = (n - x + 1) / 8
    static int xy2n(int x, int y) {
        assert x > 0 && x < 9
        assert y > 0 && y < 9
        return x + (y - 1) * 8
    }

    @Override
    String toString() {
        return "[" + column + row + "]"
    }
}
