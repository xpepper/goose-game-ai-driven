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

    fun movePlayer(name: String, dice: Dice): String {
        val player = playerWithName(name) ?: return "Player not found"
        val oldPosition = player.position() ?: return "Player position not found"
        val roll = dice.roll()
        val newPosition = updatePlayerPosition(player, roll)

        return generateMoveMessage(name, roll, oldPosition, newPosition)
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun Player.position() = positions[this]

    private fun updatePlayerPosition(player: Player, roll: Int): Int {
        val newPosition = (player.position() ?: 0) + roll
        positions[player] = newPosition
        return newPosition
    }

    private fun generateMoveMessage(name: String, roll: Int, oldPosition: Int, newPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        return "$name rolls $roll. $name moves from $oldPositionName to $newPosition"
    }

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}

data class Player(val name: String)
