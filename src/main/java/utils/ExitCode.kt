package utils

enum class ExitCode(val info: String = "") {
    OK,
    NO_INPUT_FILE("No input file provided as the first parameter of the program"),
    INVALID_INPUT_FILE("Invalid input file (Not a valid file or it doesn't exist)"),
    INPUT_FILE_READ_ERROR("Couldn't read the content of the input file"),
    SYNTAX_ERROR("Syntax error while creating the parse tree"),
    INTERNAL_PARSE_ERROR("Internal error while creating parse tree"),
    EMPTY_FLOW("The flow of the program is empty")
}