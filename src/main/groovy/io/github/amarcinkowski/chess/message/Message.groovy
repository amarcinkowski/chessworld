package io.github.amarcinkowski.chess.message

import groovy.util.logging.Slf4j

/**
 * https://docs.google.com/spreadsheets/d/1_9vf_KQ3FX-hva6D5IAeOWYtRfvJor2fggcdyh1YlBw/edit#gid=0
 */
@Slf4j
class Message {

    static locale
    public static ResourceBundle msgFile
    final static msgs = [:]

    static language(String language) {
        locale = new Locale(language.toLowerCase(), language.toUpperCase())
        loadMsgs()
    }

    static loadMsgs() {
        msgFile = ResourceBundle.getBundle("message", locale)
        for (String key : msgFile.keySet()) {
            def value = msgFile.getObject(key)
            msgs.put(value, key)
        }
    }

    static String byValue(String value) {
        msgs.get(value)
    }

    static String get(String... params) {
        def key = params.findAll { 'null' != it }.join('.')
        (key == '' || key == null) ?
                null
                :
                msgFile.getObject(key) ?: null
    }

}
