package com.sistemasaludador.app;

import com.sistemasaludador.dominio.DatosEstudiante;
import java.util.Optional;

/**
 * El sistema solicita los datos. La UI concreta (diálogo, otra ventana, consola)
 * se puede cambiar sin tocar el flujo.
 */
@FunctionalInterface
public interface CapturaDatosEstudiante {

    Optional<DatosEstudiante> capturar();
}
