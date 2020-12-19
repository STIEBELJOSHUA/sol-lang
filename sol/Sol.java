package sol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Sol {

    static boolean hasError = false;

    //runs program with command line arguments
    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Too many arguments! To run a lox file, type: jlox [file]. To open the REPL, just type jlox");
            System.exit(64);
        } else if (args.length == 1) {
            readFile(args[0]);
        } else {
            System.out.println("Welcome to the Sol 0.9.0 REPL!");
            System.out.println("(press q to quit)");
            repl();
        }
    }

    //reads in program file and runs it
    private static void readFile(String filePath) throws IOException {
        String file = new String(Files.readAllBytes(Paths.get(filePath)));
        run(file);
        if(hasError) System.exit(65);
    }

    //launches the repl
    private static void repl(){
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.print("~> ");
            String line = input.nextLine();
            if(line.equals("q")){
                System.exit(0);
            }
            else if(line != null){
                run(line);
                hasError = false;
                }
            }
        }

    //runs program
    private static void run(String line){
        Lexer lexer = new Lexer(line);
        List<Token> tokens = scanner.scanTokens();

        for (Token token : tokens){
            System.out.println(token);
        }

    }

    static void error(int line, String message){
        System.err.println("Error on line " + line + ": " + message);
        hasError = true;
    }

}

