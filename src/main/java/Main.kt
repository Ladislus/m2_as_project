import utils.ExitCode
import utils.buildAST
import utils.exitWithCode
import visitor.flow.ForwardFlow
import visitor.flow.IFlow
import visitor.printers.ASTPrinter
import visitor.printers.Printer

fun main(args: Array<String>) {
    if (args.isEmpty()) exitWithCode(ExitCode.NO_INPUT_FILE)
    val program = buildAST(args[0])
    program?.let {

        println("############### PRINTER ###############")
        println(Printer().visit(it))
        println("############### PRINTER ###############\n")

        println("############### AST ###############")
        println(ASTPrinter().visit(it))
        println("############### AST ###############\n")

        println("############### FORWARD FLOW ###############")
        val flow: IFlow = ForwardFlow()
        flow.constructFlow(it)
        println("############### FORWARD FLOW ###############\n")
    }
    exitWithCode(ExitCode.OK)
}