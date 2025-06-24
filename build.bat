@echo off
REM MOC Compiler Build Script

echo === Building MOC Compiler ===

REM Set paths for ANTLR (local jar in lib directory)
set ANTLR_PATH=lib\antlr-4.7.2-complete.jar

REM Generate parser from grammar
echo Generating parser from grammar...
java -jar %ANTLR_PATH% -visitor grammar\MOC.g4 -o src

REM Compile all Java files
echo Compiling Java files...
javac -cp ".;%ANTLR_PATH%" src\*.java -d bin

echo === Build Complete ===
