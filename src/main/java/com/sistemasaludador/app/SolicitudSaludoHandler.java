package com.sistemasaludador.app;

/**
 * Contrato del paso 1: el estudiante solicita un saludo.
 * El controlador de la vista no sabe qué ocurre después; solo dispara esta acción.
 */
@FunctionalInterface
public interface SolicitudSaludoHandler {

    void solicitarSaludo();
}
