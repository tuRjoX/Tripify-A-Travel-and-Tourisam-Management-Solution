@echo off
set "JAR_DIR=D:\TRIPIFY"
for /r "%JAR_DIR%" %%i in (*.jar) do (
    jar -xvf "%%i"
)
