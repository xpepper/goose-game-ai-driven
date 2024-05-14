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
        val newPosition = player.getPosition()

        val response = generateMoveMessage(player, roll, oldPosition, newPosition)
        if (player.hasWon()) {
            return "$response. ${player.name} Wins!!"
        }
        return response
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun generateMoveMessage(player: Player, roll: Int, oldPosition: Int, newPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        var response = "${player.name} rolls $roll. ${player.name} moves from $oldPositionName to "
        response += if (newPosition < oldPosition) {
            "${63}. ${player.name} bounces! ${player.name} returns to $newPosition"
        } else {
            "$newPosition"
        }
        return response
    }

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}
