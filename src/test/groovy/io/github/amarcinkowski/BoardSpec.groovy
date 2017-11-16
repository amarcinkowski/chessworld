package io.github.amarcinkowski

import spock.lang.Specification

/**
 * Created by am on 16.11.17.
 */
class BoardSpec extends Specification {

    def "Board should look like this"() {
        given:
        def board = new Board()
        expect:
        println "xxxx${board}XXXX"
        assert board ==
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "_ _ _ _ _ _ _ _\n" +
                "p p p p p p p p\n" +
                "r n b q k b n r\n" +
                "P P P P P P P P\n" +
                "R N B Q K B N R"
    }
}
