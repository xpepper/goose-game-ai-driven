class Game(private val dice: Dice = Dice()) {
    private val players = mutableListOf<Player>()

    fun addPlayer(player: Player): String {
        if (player.isAlreadyPresent()) {
            return "${player.name}: already existing player"
        }
        players.add(player)
        return "players: ${playersInGame()}"
    }

    fun movePlayer(player: Player): String {
        if (!players.contains(player)) {
            return "Player not found"
        }

        val oldPosition = player.getPosition()
        val (dice1, dice2) = dice.roll()
        player.move(dice1 + dice2)

        val response = generateMoveMessage(player, dice1, dice2, oldPosition)
        if (player.hasWon()) {
            return "$response. ${player.name} Wins!!"
        }
        return response
    }

    private fun playerWithName(name: String) = players.find { it.name == name }

    private fun generateMoveMessage(player: Player, dice1: Int, dice2: Int, oldPosition: Int): String {
        val oldPositionName = if (oldPosition == 0) "Start" else oldPosition.toString()
        var response = "${player.name} rolls $dice1, $dice2. ${player.name} moves from $oldPositionName to "
        response += if (player.bouncedFrom(oldPosition)) {
            bounceMessage(player)
        } else {
            "${player.getPosition()}"
        }
        return response
    }

    private fun bounceMessage(player: Player) = "${63}. ${player.name} bounces! ${player.name} returns to ${player.getPosition()}"

    private fun Player.bouncedFrom(oldPosition: Int) = getPosition() < oldPosition

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}
