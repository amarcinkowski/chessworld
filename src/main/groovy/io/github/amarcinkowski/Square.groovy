package io.github.amarcinkowski

import groovy.transform.builder.Builder
import groovy.transform.builder.SimpleStrategy
import groovy.util.logging.Slf4j

import java.awt.Point

/**
 * Created by am on 15.11.17.
 */
@Slf4j
@Builder(builderStrategy = SimpleStrategy)
class Square {
    Character column
    Integer row

    public Square(String a1) {
        this.setA1(a1)
    }

    public Square() {
    }

    void setA1(String a1) {
        this.column = a1.charAt(0)
        this.row = a1.charAt(1).toString().toInteger()
    }

    String getA1() {
        this.column.toString() + row.toString()
    }

    int getX() {
        (int) column - (int) 'a' + 1
    }

    int getY() {
        a1.charAt(1).toString().toInteger()
    }

    // TODO SquareFactory / SquareBuilder
    static int[] a12xy(String a1) {
        def column = a1.charAt(0)
        def row = a1.charAt(1).toString().toInteger()
        [row, (int) column - (int) 'a']
    }

    // TODO SquareFactory / SquareBuilder
    int getN() {
        getX() + (getY() - 1) * 8
    }

    Square setN(int n) {
        log.info "SQUARE n $n"
        int[] xy = n2xy(n)
        log.info "xy $xy"
        column = Character.valueOf((char) ((int) 'a' + xy[0] - 1))
        row = xy[1]
        log.info "$column$row"
        this
    }

    // TODO SquareFactory / SquareBuilder
    static int[] n2xy(int n) {
        assert n > 0 && n < 65
        [((n - 1) % 8) + 1, Math.ceil(n / 8)]
    }

    // TODO SquareFactory / SquareBuilder
    // n = x + (y - 1) * 8
    // x = n - 8y +8
    // y = (n - x + 1) / 8
    static int xy2n(int x, int y) {
        assert x > 0 && x < 9
        assert y > 0 && y < 9
        x + (y - 1) * 8
    }

    @Override
    String toString() {
        "[" + column + row + "]"
    }
}
