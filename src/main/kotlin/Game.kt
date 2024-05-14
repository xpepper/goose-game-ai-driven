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
        val oldPosition = player.getPosition()
        val roll = dice.roll()
        player.move(roll)

        val response = generateMoveMessage(name, roll, oldPosition, player.getPosition())
        if (player.getPosition() == 63) {
            return "$response. ${player.name} Wins!!"
        }
        return response
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun generateMoveMessage(name: String, roll: Int, oldPosition: Int, newPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        return "$name rolls $roll. $name moves from $oldPositionName to $newPosition"
    }

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}

data class Player(val name: String, private var position: Int = 0) {
    fun move(roll: Int) {
        position += roll
    }

    fun getPosition(): Int {
        return position
    }
}
