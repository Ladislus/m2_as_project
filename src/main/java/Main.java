import ast.Program;
import utils.ExitCode;

import static utils.ErrorHandler.exitWithError;
import static utils.Utils.buildAST;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) exitWithError(ExitCode.NO_INPUT_FILE);
        Program program = buildAST(args[0]);
    }
}
