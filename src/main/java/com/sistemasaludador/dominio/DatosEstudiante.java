package com.sistemasaludador.dominio;

import java.util.Objects;

/**
 * Datos capturados del estudiante. El dominio no sabe de JavaFX;
 * solo guarda lo necesario para saludar después.
 */
public record DatosEstudiante(String nombre, int edad, PeriodoHorario periodoHorario) {

    public DatosEstudiante {
        Objects.requireNonNull(nombre, "nombre");
        Objects.requireNonNull(periodoHorario, "periodoHorario");
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (edad < 1) {
            throw new IllegalArgumentException("La edad debe ser positiva");
        }
    }
}
