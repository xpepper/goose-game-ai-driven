class Game {
    private val players = mutableListOf<String>()

    fun addPlayer(name: String) {
        if (name in players) {
            return // Consider logging or handling this case explicitly if needed
        }
        players += name
    }

    fun playersList(): String = "players: ${players.joinToString(", ")}"
}
