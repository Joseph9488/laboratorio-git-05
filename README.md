# Sistema Saludador

Aplicación de escritorio en **Java / JavaFX**. El estudiante solicita un saludo, el sistema pide nombre, edad y hora (AM/PM) y responde saludándolo por su nombre y mencionando su edad.

## Requisitos

- JDK 24 o superior (en este equipo se usó JDK 26).
- Variable de entorno `JAVA_HOME` apuntando al JDK. Si no está definida, `ejecutar.cmd` usa:

  `C:\Program Files\Java\jdk-26.0.2.1`

Maven no hace falta instalarlo: el proyecto incluye Maven Wrapper (`mvnw.cmd`).

## Cómo ejecutar el software

En PowerShell o CMD, desde la carpeta del proyecto:

```bat
ejecutar.cmd
```

Equivalente:

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.2.1"
.\mvnw.cmd javafx:run
```

Uso esperado:

1. Clic en **Solicitar saludo**.
2. El sistema pide nombre, edad y AM/PM.
3. El estudiante ingresa los datos y pulsa **Aceptar**.
4. El sistema muestra el saludo (por ejemplo: `Buenos días, Ana. Tienes 20 años.`).
5. **Volver** regresa a la pantalla inicial.

## Pruebas

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-26.0.2.1"
.\mvnw.cmd test
```

## Ejecutable Windows (.exe)

```bat
empaquetar.cmd
```

## Estructura

```
src/main/java/com/sistemasaludador/
  dominio/     datos, validación y texto del saludo
  app/         flujo del caso de uso
  ui/          pantallas JavaFX (inicio, formulario, saludo)
prompts/       secuencia de prompts (secuencia.txt)
docs/          reflexión y notas de entrega
```

## Entrega

- Código: este repositorio.
- Cómo ejecutar: esta página.
- Prompts: `prompts/secuencia.txt`.
- Reflexión: `docs/reflexion.md`.
