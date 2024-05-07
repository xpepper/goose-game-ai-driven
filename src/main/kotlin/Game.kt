class Game {
    private val players = mutableListOf<Player>()

    fun addPlayer(player: Player): String {
        if (players.any { it.name == player.name }) {
            return "${player.name}: already existing player"
        }
        players.add(player)
        return "players: ${playersInGame()}"
    }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}

data class Player(val name: String)
