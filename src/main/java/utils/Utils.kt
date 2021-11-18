package utils

import org.antlr.v4.runtime.CharStreams
import antlr.parser.WhileLexer
import antlr.parser.WhileParser
import ast.Program
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import java.io.*


private fun getInputStream(filepath: String): InputStream? {
    return try {
        val inputFile = File(filepath)
        FileInputStream(inputFile)
    } catch (exception: FileNotFoundException) {
        exception.printStackTrace()
        exitWithCode(ExitCode.INVALID_INPUT_FILE)
        null
    }
}

private fun parse(inputStream: InputStream): ParseTree? {
    return try {
        val input = CharStreams.fromStream(inputStream)
        val lexer = WhileLexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = WhileParser(tokens)
        val tree = parser.program() as ParseTree
        if (parser.numberOfSyntaxErrors != 0) exitWithCode(ExitCode.SYNTAX_ERROR)
        tree
    } catch (e: IOException) {
        e.printStackTrace()
        exitWithCode(ExitCode.INPUT_FILE_READ_ERROR)
        null
    }
}

fun buildAST(filepath: String): Program? {
    val inputStream = getInputStream(filepath)!!
    val parseTree = parse(inputStream)
    return if (parseTree == null) {
        exitWithCode(ExitCode.INTERNAL_PARSE_ERROR)
        null
    } else parseTree.accept(ASTBuilder()) as Program
}