package utils;


import static java.lang.System.exit;

public class ErrorHandler {

    public static void exitWithError(ExitCode exitCode) {
        System.err.println(exitCode.getInfo());
        exit(exitCode.ordinal());
    }
}
