class Game {
    private val players = mutableListOf<String>()

    fun addPlayer(name: String) {
        if (!players.contains(name)) {
            players.add(name)
        }
    }

    fun playersList(): String {
        return "players: ${players.joinToString(", ")}"
    }
}
