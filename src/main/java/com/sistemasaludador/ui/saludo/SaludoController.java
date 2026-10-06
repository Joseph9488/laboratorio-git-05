package com.sistemasaludador.ui.saludo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Pantalla final: muestra el saludo y permite volver al inicio.
 */
public class SaludoController {

    private final Runnable alVolver;

    @FXML
    private Label mensajeLabel;

    public SaludoController(Runnable alVolver) {
        this.alVolver = alVolver;
    }

    public void mostrarMensaje(String mensaje) {
        mensajeLabel.setText(mensaje);
        mensajeLabel.setWrapText(true);
    }

    @FXML
    private void onVolver() {
        alVolver.run();
    }
}
