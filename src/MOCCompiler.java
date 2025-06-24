import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


// Classe principal do compilador MOC

public class MOCCompiler {
    public static void main(String[] args) {
        // Verifica se foi fornecido um ficheiro de entrada
        if (args.length < 1) {
            System.err.println("Uso: java MOCCompiler <arquivo.moc>");
            System.exit(1);
        }

        String inputFile = args[0];
        try {
            // Lê o código-fonte do ficheiro de entrada
            String sourceCode = new String(Files.readAllBytes(Paths.get(inputFile)));

            // Cria o analisador léxico (lexer) para tokenizar o código
            MOCLexer lexer = new MOCLexer(CharStreams.fromString(sourceCode));
            
            // Cria o analisador sintático (parser) utilizando os tokens do lexer
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MOCParser parser = new MOCParser(tokens);
            
            // Obtém a Árvore Sintática Abstrata (AST) a partir do parser
            ParseTree ast = parser.start();
            
            // Cria o visitante para gerar código TAC a partir da AST
            MOCTACVisitor tacVisitor = new MOCTACVisitor();
            tacVisitor.visit(ast);
            
            // Obtém o código TAC gerado
            TAC tac = tacVisitor.getTAC();
            List<String> tacCode = tac.getCode();
            
            // Imprime o código TAC original no ecrã
            System.out.println("Código TAC original:");
            System.out.println("------------------");
            
            for (String line : tacCode) {
                System.out.println(line);
            }
            
            // Aplica otimizações ao código
            TACOptimizer optimizer = new TACOptimizer(tac);
            TAC optimizedTAC = optimizer.optimize();
            List<String> optimizedCode = optimizedTAC.getCode();
            
            // Imprime o código TAC otimizado no ecrã
            System.out.println("\nCódigo TAC otimizado:");
            System.out.println("------------------");
            
            for (String line : optimizedCode) {
                System.out.println(line);
            }
            
            // Guarda o código TAC original num ficheiro .tac, para futura comparação, usamos para debug
            String outputFile = inputFile.replace(".moc", ".tac");
            Files.write(Paths.get(outputFile), tacCode);
            System.out.println("\nCódigo TAC original salvo em: " + outputFile);
            
            // Guarda o código TAC otimizado num ficheiro .opt.tac, para futura comparação, usamos para debug
            String optimizedOutputFile = inputFile.replace(".moc", ".opt.tac");
            Files.write(Paths.get(optimizedOutputFile), optimizedCode);
            System.out.println("Código TAC otimizado salvo em: " + optimizedOutputFile);

            // === GERAÇÃO DE CÓDIGO P3 ===
            // Gera código P3 a partir do TAC otimizado
            P3Generator p3Generator = new P3Generator(optimizedCode);
            List<String> p3Code = p3Generator.generate();

            System.out.println("DEBUG: p3Code size = " + p3Code.size());
for (String line : p3Code) System.out.println("P3: " + line);

            // Imprime o código P3 no ecrã
            System.out.println("\nCódigo P3 gerado:");
            System.out.println("------------------");
            for (String line : p3Code) {
                System.out.println(line);
            }

            // Salva o código P3 num ficheiro .p3
            String p3OutputFile = inputFile.replace(".moc", ".as");
            Files.write(Paths.get(p3OutputFile), p3Code);
            System.out.println("Código P3 salvo em: " + p3OutputFile);

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
            System.exit(1);
        }
    }
}
