@echo off
cd D:\TRIPIFY
del *.class /s /q
del /f INFO_BIN
del /f INFO_SRC
del /f LICENSE
del /f README
rmdir /s /q com
rmdir /s /q javax
rmdir /s /q META-INF
rmdir /s /q net
rmdir /s /q org
rmdir /s /q src
del /f javac.20230501_165656.args
del /f javac.20230501_170005.args
del /f javac.20230514_093958.args