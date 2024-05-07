class Game {
    private val players = mutableListOf<String>()

    fun addPlayer(name: String): String {
        players.add(name)
        return "players: ${players.joinToString(", ")}"
    }
}
