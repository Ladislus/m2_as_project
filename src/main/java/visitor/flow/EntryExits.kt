package visitor.flow

data class EntryExits(
    val _entry: State,
    val _exits: MutableList<State> = mutableListOf(),
)