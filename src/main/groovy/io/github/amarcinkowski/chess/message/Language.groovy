package io.github.amarcinkowski.chess.message

enum Language {

    DEFAULT('en'), ENGLISH('en'), POLISH('pl'), SYMBOL('eo')

    def Locale locale

    def Language(String iso) {
        this.locale = new Locale(iso, iso.toUpperCase())
    }

}
