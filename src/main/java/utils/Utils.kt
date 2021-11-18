package utils

import utils.ExitCode
import org.antlr.v4.runtime.CharStreams
import antlr.parser.WhileLexer
import antlr.parser.WhileParser
import ast.Program
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import utils.ASTBuilder
import java.io.*

object Utils {
    private fun getInputStream(filepath: String): InputStream? {
        try {
            val f = File(filepath)
            return FileInputStream(f)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            ErrorHandler.exitWithError(ExitCode.INVALID_INPUT_FILE)
        }
        return null
    }

    private fun parse(`is`: InputStream?): ParseTree? {
        try {
            val input = CharStreams.fromStream(`is`)
            val lexer = WhileLexer(input)
            val tokens = CommonTokenStream(lexer)
            val parser = WhileParser(tokens)
            val tree = parser.program() as ParseTree
            if (parser.numberOfSyntaxErrors != 0) ErrorHandler.exitWithError(ExitCode.SYNTAX_ERROR)
            return tree
        } catch (e: IOException) {
            e.printStackTrace()
            ErrorHandler.exitWithError(ExitCode.INPUT_FILE_READ_ERROR)
        }
        return null
    }

    fun buildAST(filepath: String): Program? {
        val `is` = getInputStream(filepath)
        val pt = parse(`is`)
        return if (pt == null) {
            ErrorHandler.exitWithError(ExitCode.INTERNAL_PARSE_ERROR)
            null
        } else pt.accept(ASTBuilder()) as Program
    }
}