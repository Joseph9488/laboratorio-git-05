package com.sistemasaludador.dominio;

import java.util.Optional;

/**
 * Valida el texto crudo del formulario antes de crear {@link DatosEstudiante}.
 */
public final class ValidadorDatosEstudiante {

    private static final int EDAD_MINIMA = 1;
    private static final int EDAD_MAXIMA = 120;

    public Optional<String> validar(String nombre, String edadTexto, PeriodoHorario periodoHorario) {
        if (nombre == null || nombre.isBlank()) {
            return Optional.of("Escribe tu nombre.");
        }
        if (edadTexto == null || edadTexto.isBlank()) {
            return Optional.of("Escribe tu edad.");
        }

        int edad;
        try {
            edad = Integer.parseInt(edadTexto.trim());
        } catch (NumberFormatException e) {
            return Optional.of("La edad debe ser un número entero.");
        }

        if (edad < EDAD_MINIMA || edad > EDAD_MAXIMA) {
            return Optional.of("La edad debe estar entre " + EDAD_MINIMA + " y " + EDAD_MAXIMA + ".");
        }
        if (periodoHorario == null) {
            return Optional.of("Elige AM o PM.");
        }
        return Optional.empty();
    }

    public DatosEstudiante crear(String nombre, String edadTexto, PeriodoHorario periodoHorario) {
        validar(nombre, edadTexto, periodoHorario).ifPresent(error -> {
            throw new IllegalArgumentException(error);
        });
        return new DatosEstudiante(nombre.trim(), Integer.parseInt(edadTexto.trim()), periodoHorario);
    }
}
