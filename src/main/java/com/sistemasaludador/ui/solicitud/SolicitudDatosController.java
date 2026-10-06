package com.sistemasaludador.ui.solicitud;

import com.sistemasaludador.dominio.DatosEstudiante;
import com.sistemasaludador.dominio.PeriodoHorario;
import com.sistemasaludador.dominio.ValidadorDatosEstudiante;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * Formulario que el sistema muestra al solicitar un saludo.
 */
public class SolicitudDatosController {

    private final ValidadorDatosEstudiante validador = new ValidadorDatosEstudiante();

    @FXML
    private TextField nombreField;
    @FXML
    private TextField edadField;
    @FXML
    private ToggleGroup periodoGroup;
    @FXML
    private RadioButton amRadio;
    @FXML
    private RadioButton pmRadio;
    @FXML
    private Label errorLabel;

    private Stage dialogo;
    private Optional<DatosEstudiante> resultado = Optional.empty();

    @FXML
    private void initialize() {
        amRadio.setUserData(PeriodoHorario.AM);
        pmRadio.setUserData(PeriodoHorario.PM);
    }

    public void asociarDialogo(Stage dialogo) {
        this.dialogo = dialogo;
    }

    public Optional<DatosEstudiante> resultado() {
        return resultado;
    }

    @FXML
    private void onAceptar() {
        PeriodoHorario periodo = periodoSeleccionado();
        Optional<String> error = validador.validar(nombreField.getText(), edadField.getText(), periodo);
        if (error.isPresent()) {
            errorLabel.setText(error.get());
            return;
        }

        resultado = Optional.of(validador.crear(nombreField.getText(), edadField.getText(), periodo));
        cerrar();
    }

    @FXML
    private void onCancelar() {
        resultado = Optional.empty();
        cerrar();
    }

    private PeriodoHorario periodoSeleccionado() {
        if (periodoGroup.getSelectedToggle() == null) {
            return null;
        }
        return (PeriodoHorario) periodoGroup.getSelectedToggle().getUserData();
    }

    private void cerrar() {
        if (dialogo != null) {
            dialogo.close();
        }
    }
}
