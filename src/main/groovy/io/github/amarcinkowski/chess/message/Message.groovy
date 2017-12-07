package io.github.amarcinkowski.chess.message

import groovy.util.logging.Slf4j

import java.text.DateFormat

/**
 * https://docs.google.com/spreadsheets/d/1_9vf_KQ3FX-hva6D5IAeOWYtRfvJor2fggcdyh1YlBw/edit#gid=0
 */
@Slf4j
class Message {

    static lang
    public static ResourceBundle msgFile
    final static msgs = [:]

    static language(String lang) {
        this.lang = lang
        loadMsgs()
    }

    static loadMsgs() {
        msgFile = ResourceBundle.getBundle("message", new Locale.Builder().setLanguageTag(lang).build())
        log.trace "Loading resource bundle for locale $lang ${msgFile.getLocale()}"
        def keys = msgFile.keySet()
        for (String key : keys) {
            def value = msgFile.getObject(key)
            msgs.put(value, key)
        }
        log.debug "read ${keys.size()}: ${msgs.keySet()}"
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
