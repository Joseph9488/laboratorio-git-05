@echo off
setlocal EnableExtensions
cd /d "%~dp0"

if not defined JAVA_HOME set "JAVA_HOME=C:\Program Files\Java\jdk-26.0.2.1"
if not exist "%JAVA_HOME%\bin\jpackage.exe" (
  echo No se encontro jpackage en JAVA_HOME.
  exit /b 1
)

call mvnw.cmd -q package
if errorlevel 1 exit /b 1

if exist "dist\SistemaSaludador" rmdir /s /q "dist\SistemaSaludador"
if not exist "target\jpackage-input" mkdir "target\jpackage-input"
copy /y "target\sistema-saludador-1.0.0.jar" "target\jpackage-input\" >nul

"%JAVA_HOME%\bin\jpackage.exe" ^
  --type app-image ^
  --dest dist ^
  --name SistemaSaludador ^
  --app-version 1.0.0 ^
  --vendor "Sistema Saludador" ^
  --input target\jpackage-input ^
  --main-jar sistema-saludador-1.0.0.jar ^
  --main-class com.sistemasaludador.Launcher ^
  --module-path target\javafx-mods ^
  --add-modules javafx.controls,javafx.fxml

if errorlevel 1 exit /b 1
echo Listo: dist\SistemaSaludador\SistemaSaludador.exe
endlocal
