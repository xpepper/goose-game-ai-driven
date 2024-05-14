class Game {
    private val players = mutableListOf<Player>()

    fun addPlayer(player: Player): String {
        if (player.isAlreadyPresent()) {
            return "${player.name}: already existing player"
        }
        players.add(player)
        return "players: ${playersInGame()}"
    }

    fun movePlayer(name: String, dice: Dice): String {
        val player = playerWithName(name) ?: return "Player not found"
        val oldPosition = player.position
        val roll = dice.roll()
        player.position += roll

        return generateMoveMessage(name, roll, oldPosition, player.position)
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun generateMoveMessage(name: String, roll: Int, oldPosition: Int, newPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        return "$name rolls $roll. $name moves from $oldPositionName to $newPosition"
    }

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}

data class Player(val name: String, var position: Int = 0)
