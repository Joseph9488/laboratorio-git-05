package com.sistemasaludador.ui.inicio;

import com.sistemasaludador.app.SolicitudSaludoHandler;
import javafx.fxml.FXML;

/**
 * Vista inicial. Su única responsabilidad es reaccionar al botón
 * y delegar el caso de uso; no pide datos ni arma el saludo.
 */
public class InicioController {

    private final SolicitudSaludoHandler solicitudSaludoHandler;

    public InicioController(SolicitudSaludoHandler solicitudSaludoHandler) {
        this.solicitudSaludoHandler = solicitudSaludoHandler;
    }

    @FXML
    private void onSolicitarSaludo() {
        solicitudSaludoHandler.solicitarSaludo();
    }
}
