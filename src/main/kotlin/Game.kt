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

        val response = generateMoveMessage(player, roll, oldPosition)
        if (player.hasWon()) {
            return "$response. ${player.name} Wins!!"
        }
        return response
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun generateMoveMessage(player: Player, roll: Int, oldPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        return "${player.name} rolls $roll. ${player.name} moves from $oldPositionName to ${player.getPosition()}"
    }

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}

