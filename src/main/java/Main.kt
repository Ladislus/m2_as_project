import utils.ExitCode
import utils.buildAST
import utils.exitWithCode
import visitor.analyse.IAnalyse
import visitor.analyse.availableExpressions.AvailableExpressionsAnalyse
import visitor.analyse.liveVariable.LiveVariableAnalyse
import visitor.analyse.reachingDefinition.ReachingDefinitionAnalyse
import visitor.analyse.veryBusyExpression.VeryBusyExpressionAnalyse
import visitor.flow.Flow
import visitor.flow.IFlow
import visitor.printers.ASTPrinter
import visitor.printers.Printer
import java.io.File

fun help() {
    println("Usage: java <input-file> [<flag>]*")
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        help()
        exitWithCode(ExitCode.NO_INPUT_FILE)
    }

    if (args.contains("-h") || args.contains("--help")) {
        help()
        exitWithCode(ExitCode.OK)
    }

    val program = buildAST(args[0])
    program?.let {

        if (args.contains("-v") || args.contains("--verbose")) {
            println("############### PRINTER ###############")
            println(Printer().visit(it))
            println("############### PRINTER ###############\n")
        }

        if (args.contains("-a") || args.contains("--ast")) {
            println("############### AST ###############")
            println(ASTPrinter().visit(it))
            println("############### AST ###############\n")
        }

        // Available expressions
        if (args.contains("-ae")) {
            println("############### AE ###############")
            val flow: IFlow = Flow(it, false)
            File("./flow_ae.dot").writeText(flow.toDot())
            if (args.contains("-d") || args.contains("--dot")) {
                val cmd = "dot -Tpng ./flow_ae.dot -o ./flow_ae.png"
                println("[CMD] $cmd")
                Runtime.getRuntime().exec(cmd)
            }
            val availableExpressionsAnalyse: IAnalyse = AvailableExpressionsAnalyse(flow)
            availableExpressionsAnalyse.analyse()
            println("############### AE ###############\n")
        }


        // Reaching definition
        if (args.contains("-rd")) {
            println("############### RD ###############")
            val flow = Flow(it, false)
            File("./flow_rd.dot").writeText(flow.toDot())
            if (args.contains("-d") || args.contains("--dot")) {
                val cmd = "dot -Tpng ./flow_rd.dot -o ./flow_rd.png"
                println("[CMD] $cmd")
                Runtime.getRuntime().exec(cmd)
            }
            val reachingDefinitionAnalyse: IAnalyse = ReachingDefinitionAnalyse(flow)
            reachingDefinitionAnalyse.analyse()
            println("############### RD ###############\n")
        }

        // Live variable
        if (args.contains("-lv")) {
            println("############### LV ###############")
            val flow = Flow(it, true)
            File("./flow_lv.dot").writeText(flow.toDot())
            if (args.contains("-d") || args.contains("--dot")) {
                val cmd = "dot -Tpng ./flow_lv.dot -o ./flow_lv.png"
                println("[CMD] $cmd")
                Runtime.getRuntime().exec(cmd)
            }
            val liveVariableAnalyse: IAnalyse = LiveVariableAnalyse(flow)
            liveVariableAnalyse.analyse()
            println("############### LV ###############\n")
        }

        // Very busy
        if (args.contains("-vb")) {
            println("############### VB ###############")
            val flow = Flow(it, true)
            File("./flow_vb.dot").writeText(flow.toDot())
            if (args.contains("-d") || args.contains("--dot")) {
                val cmd = "dot -Tpng ./flow_vb.dot -o ./flow_vb.png"
                println("[CMD] $cmd")
                Runtime.getRuntime().exec(cmd)
            }
            val veryBusyExpressionAnalyse: IAnalyse = VeryBusyExpressionAnalyse(flow)
            veryBusyExpressionAnalyse.analyse()
            println("############### VB ###############\n")
        }
    }
    exitWithCode(ExitCode.OK)
}