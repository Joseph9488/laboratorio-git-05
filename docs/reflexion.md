# Reflexión sobre lo realizado

Trabajo del Sistema Saludador en Java/JavaFX, hecho en Cursor.

## Retos

El primero fue no lanzarme a programar. El enunciado pide un orden concreto: el estudiante pulsa **Solicitar saludo** y *después* el sistema pide los datos. Si el formulario aparece desde el inicio, el caso de uso no se cumple.

En la máquina no había Maven ni Git en el PATH. Java sí (JDK 26). Eso obligó a usar Maven Wrapper y a documentar `JAVA_HOME`. JavaFX tampoco viene dentro del JDK; hay que declararlo como dependencia.

Otro reto fue no mezclar todo en un solo controlador: pantallas, validación y texto del saludo. Funciona para un trabajo corto, pero luego cuesta añadir cosas.

## Estructura del software

Quedó en tres capas:

- **dominio**: `DatosEstudiante`, `PeriodoHorario`, validación y `GeneradorSaludo`. No conocen JavaFX.
- **app**: `FlujoSaludo` une clic → captura de datos → saludo.
- **ui**: FXML y controladores (inicio, formulario modal, pantalla del mensaje).

El clic del botón no arma el texto. Solo avisa al flujo. El flujo pide datos (hoy un diálogo) y le pasa el resultado al generador. Si mañana el formulario es otra ventana, el flujo no cambia.

AM y PM no salen como “AM/PM” en el mensaje; sirven para *Buenos días* o *Buenas tardes*, y el saludo sí nombra a la persona y su edad, como pide el enunciado.

## Descubrimientos

- **FXML** separa el diseño de la lógica. El controlador recibe eventos (`onSolicitarSaludo`, `onAceptar`).
- **Maven Wrapper** (`mvnw.cmd`) descarga Maven solo; no hay que instalarlo.
- Un **diálogo modal** encaja con “el sistema solicita”: bloquea la ventana principal hasta Aceptar o Cancelar.

## Comandos y librerías que al principio no comprendí

- `mvnw.cmd javafx:run`: Maven no “es” JavaFX; el plugin pone JavaFX en el módulo path y arranca la aplicación.
- `JAVA_HOME`: el wrapper no se conforma con tener `java` en el PATH; pide la carpeta del JDK.
- `org.openjfx:javafx-controls` y `javafx-fxml`: controles (botón, campos) y carga de FXML.
- `jpackage --type app-image`: no es un instalador tipo Setup; es la app lista para ejecutar en Windows.

Maven, al inicio, parecía otra capa innecesaria. En la práctica evita copiar JARs a mano y deja el proyecto reproducible.

## Sorpresas

Me sorprendio bastante la formalidad con lo que hace las cosas, hace todo de forma bastante formal y rapida a pesar de tener tan poco tiempo o pocos tokens antes de llegar al limite, el problema es que toca usar bastante bien las preguntas porque de resto puede hacer mucho mas de lo que se le necesita o de lo que se le dice que hacer.

La formalidad del codigo parece bien a pesar de todo, quizas un poco sobrecompleto con poca explicacion pero a la vez explica muy bien las funciones creadas.


