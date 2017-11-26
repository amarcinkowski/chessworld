package io.github.amarcinkowski

import groovy.util.logging.Slf4j

/**
 * https://docs.google.com/spreadsheets/d/1_9vf_KQ3FX-hva6D5IAeOWYtRfvJor2fggcdyh1YlBw/edit#gid=0
 */
@Slf4j
class Message {

    final static msgs = [:]

    // FIXME XXX is READING all languages messages necessary? -> read just Game.locale msgs
    static {
        for (Language lang : Language.values()) {
            def resource = ResourceBundle.getBundle("message", lang.locale())
            def keys = resource.keySet()
            for (String key : keys) {
                def value = resource.getObject(key)
                msgs.put(lang.toString() + value, key)
            }
        }
    }

    static String byValue(String value) {
        msgs.get(value)
    }

    static String get(String... params) {
        def key = params.findAll { 'null' != it }.join('.') // 'king', 'white' -> 'king.white' TODO king.white -> white.king
        ResourceBundle.getBundle("message", Game.locale).getObject(key)
    }

}
