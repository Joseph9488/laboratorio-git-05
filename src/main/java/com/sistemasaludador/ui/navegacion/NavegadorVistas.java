package com.sistemasaludador.ui.navegacion;

import com.sistemasaludador.dominio.DatosEstudiante;
import com.sistemasaludador.ui.saludo.SaludoController;
import com.sistemasaludador.ui.solicitud.SolicitudDatosController;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Carga vistas FXML y las muestra en la ventana principal o en un diálogo.
 */
public final class NavegadorVistas {

    private static final String TITULO = "Sistema Saludador";
    private static final String INICIO_FXML = "/com/sistemasaludador/ui/inicio/inicio-view.fxml";
    private static final String SOLICITUD_FXML = "/com/sistemasaludador/ui/solicitud/solicitud-datos-view.fxml";
    private static final String SALUDO_FXML = "/com/sistemasaludador/ui/saludo/saludo-view.fxml";
    private static final double ANCHO = 480;
    private static final double ALTO = 340;

    private final Stage escenario;
    private Callback<Class<?>, Object> fabricaControladores;

    public NavegadorVistas(Stage escenario) {
        this.escenario = escenario;
    }

    public void configurarFabrica(Callback<Class<?>, Object> fabricaControladores) {
        this.fabricaControladores = fabricaControladores;
    }

    public void mostrarInicio() {
        mostrarEnPrincipal(cargar(INICIO_FXML).getRoot());
    }

    public Optional<DatosEstudiante> mostrarSolicitudDatos() {
        FXMLLoader cargador = cargar(SOLICITUD_FXML);
        SolicitudDatosController controlador = cargador.getController();

        Stage dialogo = new Stage();
        dialogo.setTitle("Solicitar datos");
        dialogo.initOwner(escenario);
        dialogo.initModality(Modality.WINDOW_MODAL);
        dialogo.setScene(new Scene(cargador.getRoot(), 420, 380));
        dialogo.setResizable(false);

        controlador.asociarDialogo(dialogo);
        dialogo.showAndWait();
        return controlador.resultado();
    }

    public void mostrarSaludo(String mensaje) {
        FXMLLoader cargador = cargar(SALUDO_FXML);
        SaludoController controlador = cargador.getController();
        controlador.mostrarMensaje(mensaje);
        mostrarEnPrincipal(cargador.getRoot());
    }

    private void mostrarEnPrincipal(Parent raiz) {
        escenario.setTitle(TITULO);
        escenario.setScene(new Scene(raiz, ANCHO, ALTO));
        escenario.show();
    }

    private FXMLLoader cargar(String rutaFxml) {
        URL recurso = NavegadorVistas.class.getResource(rutaFxml);
        if (recurso == null) {
            throw new IllegalStateException("No se encontró la vista: " + rutaFxml);
        }

        FXMLLoader cargador = new FXMLLoader(recurso);
        if (fabricaControladores != null) {
            cargador.setControllerFactory(fabricaControladores);
        }

        try {
            cargador.load();
            return cargador;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo cargar la vista: " + rutaFxml, e);
        }
    }
}
