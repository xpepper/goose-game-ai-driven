class Game {
    private val players = mutableListOf<Player>()
    private val positions = mutableMapOf<Player, Int>()

    fun addPlayer(player: Player): String {
        if (player.isAlreadyPresent()) {
            return "${player.name}: already existing player"
        }
        players.add(player)
        positions[player] = 0
        return "players: ${playersInGame()}"
    }

    fun movePlayer(name: String, dice1: Int, dice2: Int): String {
        val player = playerWithName(name) ?: return "Player not found"
        val oldPosition = player.position() ?: return "Player position not found"
        val newPosition = updatePlayerPosition(player, dice1, dice2)

        return generateMoveMessage(name, dice1, dice2, oldPosition, newPosition)
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun Player.position() = positions[this]

    private fun updatePlayerPosition(player: Player, dice1: Int, dice2: Int): Int {
        val newPosition = (player.position() ?: 0) + dice1 + dice2
        positions[player] = newPosition
        return newPosition
    }

    private fun generateMoveMessage(name: String, dice1: Int, dice2: Int, oldPosition: Int, newPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        return "$name rolls $dice1, $dice2. $name moves from $oldPositionName to $newPosition"
    }

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}

data class Player(val name: String)
