import utils.ExitCode
import utils.buildAST
import utils.exitWithCode
import visitor.analyse.IAnalyse
import visitor.analyse.availableExpressions.AvailableExpressionsAnalyse
import visitor.flow.Flow
import visitor.flow.IFlow

fun main(args: Array<String>) {
    if (args.isEmpty()) exitWithCode(ExitCode.NO_INPUT_FILE)
    val program = buildAST(args[0])
    program?.let {

//        println("############### PRINTER ###############")
//        println(Printer().visit(it))
//        println("############### PRINTER ###############\n")
//
//        println("############### AST ###############")
//        println(ASTPrinter().visit(it))
//        println("############### AST ###############\n")

        println("############### FLOW ###############")
        val flow: IFlow = Flow(it, false)
//        File("./flow.dot").writeText(flow.toDot())
//        val cmd = "dot -Tpng ./flow.dot -o ./flow.png"
//        println("[CMD] $cmd")
//        Runtime.getRuntime().exec(cmd)
        val availableExpressionsAnalyse: IAnalyse = AvailableExpressionsAnalyse(flow)
        availableExpressionsAnalyse.analyse()
//        val liveVariableAnalyse: IAnalyse = LiveVariableAnalyse(flow, true)
//        val reachingDefinitionAnalyse: IAnalyse = ReachingDefinitionAnalyse(flow, false)
//        val veryBusyExpressionAnalyse: IAnalyse = VeryBusyExpressionAnalyse(flow, true)
        println("############### FLOW ###############\n")
    }
    exitWithCode(ExitCode.OK)
}