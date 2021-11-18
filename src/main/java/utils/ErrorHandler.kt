package utils

import kotlin.system.exitProcess

fun exitWithCode(exitCode: ExitCode) {
    if (exitCode == ExitCode.OK) print("Success")
    else System.err.println(exitCode.info)
    exitProcess(exitCode.ordinal)
}
