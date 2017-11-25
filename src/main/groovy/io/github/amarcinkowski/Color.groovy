package io.github.amarcinkowski

/**
 * Created by am on 16.11.17.
 */
enum Color {
    BLACK('b'), WHITE('w'), NULL('null')

    private final String notation

    public Color(String notation) {
        this.notation = notation
    }

    @Override
    String toString() {
        name().toLowerCase()
    }
}
