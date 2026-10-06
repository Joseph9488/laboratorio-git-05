package com.sistemasaludador.dominio;

/**
 * Construye el texto del saludo a partir de los datos del estudiante.
 */
public final class GeneradorSaludo {

    public String generar(DatosEstudiante datos) {
        String apertura = switch (datos.periodoHorario()) {
            case AM -> "Buenos días";
            case PM -> "Buenas tardes";
        };
        return apertura + ", " + datos.nombre() + ". Tienes " + datos.edad() + " años.";
    }
}
