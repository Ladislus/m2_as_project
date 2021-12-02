import utils.ExitCode
import utils.buildAST
import utils.exitWithCode
import visitor.printers.Printer

fun main(args: Array<String>) {
    if (args.isEmpty()) exitWithCode(ExitCode.NO_INPUT_FILE)
    val program = buildAST(args[0])
    program?.let {
        val printer = Printer()
        println(printer.visit(it))
    }
    exitWithCode(ExitCode.OK)
}