@echo off
setlocal
cd /d "%~dp0"
if not defined JAVA_HOME set "JAVA_HOME=C:\Program Files\Java\jdk-26.0.2.1"
call mvnw.cmd javafx:run
endlocal
