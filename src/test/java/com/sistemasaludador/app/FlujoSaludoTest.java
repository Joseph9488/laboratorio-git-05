package com.sistemasaludador.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.sistemasaludador.dominio.DatosEstudiante;
import com.sistemasaludador.dominio.GeneradorSaludo;
import com.sistemasaludador.dominio.PeriodoHorario;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class FlujoSaludoTest {

    @Test
    void muestraSaludoCuandoElEstudianteIngresaDatos() {
        DatosEstudiante datos = new DatosEstudiante("Ana", 20, PeriodoHorario.AM);
        AtomicReference<String> mensaje = new AtomicReference<>();
        FlujoSaludo flujo = new FlujoSaludo(
                () -> Optional.of(datos),
                new GeneradorSaludo(),
                mensaje::set);

        flujo.solicitarSaludo();

        assertEquals("Buenos días, Ana. Tienes 20 años.", mensaje.get());
    }

    @Test
    void noSaludaSiSeCancelaLaCaptura() {
        AtomicReference<String> mensaje = new AtomicReference<>();
        FlujoSaludo flujo = new FlujoSaludo(
                Optional::empty,
                new GeneradorSaludo(),
                mensaje::set);

        flujo.solicitarSaludo();

        assertNull(mensaje.get());
    }
}
