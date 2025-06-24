# Compilador MOC

Um compilador para a linguagem MOC que gera e otimiza código TAC.

## Estrutura do Projeto

```
moc-compiler/
├── bin/                    # Arquivos de classe compilados
├── examples/               # Programas exemplo em MOC
├── grammar/                # Arquivos de gramática ANTLR
├── lib/                    # Bibliotecas externas
├── src/                    # Código fonte
├── build.bat               # Script de compilação
├── run.bat                 # Script de execução
├── run_optimizer_test.bat  # Script de teste do otimizador
└── README.txt               # Este arquivo
```

## Pré-requisitos

- Java JDK 8 ou superior
- ANTLR4

## Compilar o Compilador

Executar o script de compilação:

```
.\build.bat
```

Isso irá:
1. Gerar o parser a partir da gramática MOC.g4 a partir do ANTLR
2. Compilar todos os arquivos fonte Java

## Executar o Compilador

Para compilar um arquivo fonte MOC, vamos exemplificar com o example.moc_

```
.\run.bat examples\example.moc
```

Isso vai:
1. Compilar o arquivo MOC
2. Gerar código TAC
3. Aplicar otimizações TAC
4. Salvar tanto o código TAC original quanto o otimizado (como .tac e .opt.tac)

## Otimização TAC

Para testar o otimizador, execute o teste do otimizador:

```
.\run_optimizer_test.bat
```

Vai compilar e executar o otimizador em um arquivo de teste especial que demonstra várias oportunidades de otimização.