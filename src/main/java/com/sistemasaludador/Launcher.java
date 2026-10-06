package com.sistemasaludador;

/**
 * Arranque para empaquetado (.exe / java -jar). JavaFX exige un main
 * que no sea la subclase de Application cuando se lanza desde un JAR.
 */
public final class Launcher {

    private Launcher() {
    }

    public static void main(String[] args) {
        SaludadorApplication.main(args);
    }
}
