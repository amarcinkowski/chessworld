package io.github.amarcinkowski

import groovy.util.logging.Slf4j

/**
 * Created by am on 18.11.17.
 * https://docs.google.com/spreadsheets/d/1_9vf_KQ3FX-hva6D5IAeOWYtRfvJor2fggcdyh1YlBw/edit#gid=0
 */
@Slf4j
class Message {

    static String get(String code) {
        def locale = Game.locale ?: Locale.getDefault()
        ResourceBundle.getBundle("message", locale).getObject(code)
    }

}
