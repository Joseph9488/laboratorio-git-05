package com.sistemasaludador.dominio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValidadorDatosEstudianteTest {

    private final ValidadorDatosEstudiante validador = new ValidadorDatosEstudiante();

    @Test
    void rechazaNombreVacio() {
        assertTrue(validador.validar("  ", "20", PeriodoHorario.AM).isPresent());
    }

    @Test
    void rechazaEdadNoNumerica() {
        assertTrue(validador.validar("Ana", "veinte", PeriodoHorario.AM).isPresent());
    }

    @Test
    void aceptaDatosValidos() {
        assertTrue(validador.validar("Ana", "20", PeriodoHorario.PM).isEmpty());
    }
}
