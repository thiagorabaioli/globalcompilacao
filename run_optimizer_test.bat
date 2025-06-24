@echo off
echo Compilando o projeto...
call build.bat

REM Set paths for ANTLR (local jar in lib directory)
set ANTLR_PATH=lib\antlr-4.7.2-complete.jar

echo A apagar arquivos TAC gerados anteriormente...
if exist examples\optimization_test.tac del examples\optimization_test.tac

echo A executar o otimizador TAC no arquivo de exemplo...
java -cp "bin;%ANTLR_PATH%" MOCCompiler examples/optimization_test.moc

echo Teste concluido!
pause 