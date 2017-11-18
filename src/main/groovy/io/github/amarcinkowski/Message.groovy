package io.github.amarcinkowski

import groovy.util.logging.Slf4j

/**
 * Created by am on 18.11.17.
 */
@Slf4j
class Message {

    static locale

    static String get(String code) {
        locale = Board.locale ?: Locale.getDefault()
        def msg = ResourceBundle.getBundle("message", locale).getObject(code)
        log.trace locale.toString() + msg
        return msg
    }

}
