package com.sistemasaludador.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GeneradorSaludoTest {

    private final GeneradorSaludo generador = new GeneradorSaludo();

    @Test
    void saludaPorLaMananaConNombreYEdad() {
        DatosEstudiante datos = new DatosEstudiante("Ana", 20, PeriodoHorario.AM);
        assertEquals("Buenos días, Ana. Tienes 20 años.", generador.generar(datos));
    }

    @Test
    void saludaPorLaTardeConNombreYEdad() {
        DatosEstudiante datos = new DatosEstudiante("Luis", 19, PeriodoHorario.PM);
        assertEquals("Buenas tardes, Luis. Tienes 19 años.", generador.generar(datos));
    }
}
