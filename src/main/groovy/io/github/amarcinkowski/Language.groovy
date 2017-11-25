package io.github.amarcinkowski

/**
 * Created by am on 18.11.17.
 */
enum Language {
    DEFAULT('en'), ENGLISH('en'), POLISH('pl'), SYMBOL('eo')

    private String iso
    private Locale locale
    private Language(String iso) {
        this.iso = iso
        this.locale = new Locale(iso, iso.toUpperCase())
    }

    public Locale locale() { locale }

    @Override
    String toString() {
        this.locale.getLanguage().toString()
    }
}
