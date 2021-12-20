import utils.ExitCode
import utils.buildAST
import utils.exitWithCode
import visitor.analyse.IAnalyse
import visitor.analyse.availableExpressions.AvailableExpressionsAnalyse
import visitor.analyse.reachingDefinition.ReachingDefinitionAnalyse
import visitor.flow.Flow
import visitor.flow.IFlow
import java.io.File

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
        // Available expressions
        var flow: IFlow = Flow(it, false)
        File("./flow_ae.dot").writeText(flow.toDot())
//        val cmd = "dot -Tpng ./flow_ae.dot -o ./flow_ae.png"
//        println("[CMD] $cmd")
//        Runtime.getRuntime().exec(cmd)
        val availableExpressionsAnalyse: IAnalyse = AvailableExpressionsAnalyse(flow)
        availableExpressionsAnalyse.analyse()

        // Reaching definition
        flow = Flow(it, false)
        File("./flow_rd.dot").writeText(flow.toDot())
//        val cmd = "dot -Tpng ./flow_rd.dot -o ./flow_rd.png"
//        println("[CMD] $cmd")
//        Runtime.getRuntime().exec(cmd)
        val reachingDefinitionAnalyse: IAnalyse = ReachingDefinitionAnalyse(flow)
        reachingDefinitionAnalyse.analyse()

        // Live variable
//        flow = Flow(it, true)
//        File("./flow_lv.dot").writeText(flow.toDot())
//        val cmd = "dot -Tpng ./flow_lv.dot -o ./flow_lv.png"
//        println("[CMD] $cmd")
//        Runtime.getRuntime().exec(cmd)
//        val liveVariableAnalyse: IAnalyse = LiveVariableAnalyse(flow)
//        liveVariableAnalyse.analyse()

        // Very busy
//        flow = Flow(it, true)
//        File("./flow_vb.dot").writeText(flow.toDot())
//        val cmd = "dot -Tpng ./flow_vb.dot -o ./flow_vb.png"
//        println("[CMD] $cmd")
//        Runtime.getRuntime().exec(cmd)
//        val liveVariableAnalyse: IAnalyse = LiveVariableAnalyse(flow)
//        liveVariableAnalyse.analyse()
        println("############### FLOW ###############\n")
    }
    exitWithCode(ExitCode.OK)
}