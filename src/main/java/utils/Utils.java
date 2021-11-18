package utils;

import antlr.parser.WhileLexer;
import antlr.parser.WhileParser;
import ast.Program;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;

import static utils.ErrorHandler.exitWithError;

public class Utils {

    private static InputStream getInputStream(String filepath) {
        try {
            File f = new File(filepath);
            return new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            exitWithError(ExitCode.INVALID_INPUT_FILE);
        }
        return null;
    }

    private static ParseTree parse(InputStream is) {
        try {
            CharStream input = CharStreams.fromStream(is);
            WhileLexer lexer = new WhileLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            WhileParser parser = new WhileParser(tokens);
            ParseTree tree = (ParseTree) parser.program();
            if (parser.getNumberOfSyntaxErrors() != 0)
                exitWithError(ExitCode.SYNTAX_ERROR);
            return tree;
        } catch (IOException e) {
            e.printStackTrace();
            exitWithError(ExitCode.INPUT_FILE_READ_ERROR);
        }
        return null;
    }

    public static Program buildAST(String filepath) {
        InputStream is = getInputStream(filepath);
        ParseTree pt = parse(is);
        if (pt == null) {
            exitWithError(ExitCode.INTERNAL_PARSE_ERROR);
            return null;
        }
        else return (Program) pt.accept(new ASTBuilder());
    }
}
