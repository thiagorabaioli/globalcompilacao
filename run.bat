@echo off
REM MOC Compiler Run Script

echo === Running MOC Compiler ===

REM Set paths for ANTLR (local jar in lib directory)
set ANTLR_PATH=lib\antlr-4.7.2-complete.jar

REM Check if file is provided
if "%1"=="" (
    echo Usage: run.bat [filename.moc]
    exit /b 1
)

REM Run the compiler
echo Compiling %1...
java -cp "bin;%ANTLR_PATH%" MOCCompiler %1

echo === Compilation Complete === 