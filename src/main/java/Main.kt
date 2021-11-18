import utils.ExitCode
import utils.buildAST
import utils.exitWithCode

fun main(args: Array<String>) {
    if (args.isEmpty()) exitWithCode(ExitCode.NO_INPUT_FILE)
    val program = buildAST(args[0])
    exitWithCode(ExitCode.OK)
}