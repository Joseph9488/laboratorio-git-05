package com.sistemasaludador;

import com.sistemasaludador.app.FlujoSaludo;
import com.sistemasaludador.dominio.GeneradorSaludo;
import com.sistemasaludador.ui.inicio.InicioController;
import com.sistemasaludador.ui.navegacion.NavegadorVistas;
import com.sistemasaludador.ui.saludo.SaludoController;
import com.sistemasaludador.ui.solicitud.SolicitudDatosController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Punto de entrada de JavaFX. Arma las piezas y muestra la primera vista.
 */
public class SaludadorApplication extends Application {

    @Override
    public void start(Stage escenarioPrincipal) {
        NavegadorVistas navegador = new NavegadorVistas(escenarioPrincipal);
        FlujoSaludo flujo = new FlujoSaludo(
                navegador::mostrarSolicitudDatos,
                new GeneradorSaludo(),
                navegador::mostrarSaludo);

        Callback<Class<?>, Object> fabricaControladores = tipo -> {
            if (tipo == InicioController.class) {
                return new InicioController(flujo);
            }
            if (tipo == SolicitudDatosController.class) {
                return new SolicitudDatosController();
            }
            if (tipo == SaludoController.class) {
                return new SaludoController(navegador::mostrarInicio);
            }
            throw new IllegalStateException("Controlador no registrado: " + tipo.getName());
        };

        navegador.configurarFabrica(fabricaControladores);
        navegador.mostrarInicio();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
