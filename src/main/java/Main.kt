import kotlin.jvm.JvmStatic
import utils.ExitCode
import ast.Program
import utils.ErrorHandler
import utils.Utils

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        if (args.size < 1) ErrorHandler.exitWithError(ExitCode.NO_INPUT_FILE)
        val program = Utils.buildAST(args[0])
    }
}