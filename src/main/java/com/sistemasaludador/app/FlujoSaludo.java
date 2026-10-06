package com.sistemasaludador.app;

import com.sistemasaludador.dominio.DatosEstudiante;
import com.sistemasaludador.dominio.GeneradorSaludo;

/**
 * Orquesta el caso de uso: clic → pedir datos → saludar.
 */
public final class FlujoSaludo implements SolicitudSaludoHandler {

    private final CapturaDatosEstudiante capturaDatos;
    private final GeneradorSaludo generadorSaludo;
    private final PresentadorSaludo presentadorSaludo;

    public FlujoSaludo(
            CapturaDatosEstudiante capturaDatos,
            GeneradorSaludo generadorSaludo,
            PresentadorSaludo presentadorSaludo) {
        this.capturaDatos = capturaDatos;
        this.generadorSaludo = generadorSaludo;
        this.presentadorSaludo = presentadorSaludo;
    }

    @Override
    public void solicitarSaludo() {
        capturaDatos.capturar().ifPresent(this::continuarConSaludo);
    }

    private void continuarConSaludo(DatosEstudiante datos) {
        presentadorSaludo.mostrar(generadorSaludo.generar(datos));
    }
}
