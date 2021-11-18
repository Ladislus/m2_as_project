package utils

import utils.ExitCode.info
import utils.ExitCode
import java.lang.System

object ErrorHandler {
    fun exitWithError(exitCode: ExitCode) {
        if (exitCode === ExitCode.OK) print
        System.err.println(exitCode.info)
        System.exit(exitCode.ordinal)
    }
}