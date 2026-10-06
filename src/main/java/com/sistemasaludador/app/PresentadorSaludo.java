package com.sistemasaludador.app;

/**
 * Muestra el saludo generado. La UI concreta se puede cambiar sin tocar el flujo.
 */
@FunctionalInterface
public interface PresentadorSaludo {

    void mostrar(String mensaje);
}
