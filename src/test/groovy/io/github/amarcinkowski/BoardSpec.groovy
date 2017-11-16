package io.github.amarcinkowski

import org.slf4j.LoggerFactory
import spock.lang.Specification

/**
 * Created by am on 16.11.17.
 */
class BoardSpec extends Specification {

    def "Board should look like this"() {
        given:
        def board = new Board()
        def expected =
                "r n b q k b n r\n" +
                        "p p p p p p p p\n" +
                        "_ _ _ _ _ _ _ _\n" +
                        "_ _ _ _ _ _ _ _\n" +
                        "_ _ _ _ _ _ _ _\n" +
                        "_ _ _ _ _ _ _ _\n" +
                        "P P P P P P P P\n" +
                        "R N B Q K B N R\n"
        LoggerFactory.getLogger(BoardSpec.class).info("\n" + board.toString())
        expect:
        assert board.toString() == expected
    }
}
