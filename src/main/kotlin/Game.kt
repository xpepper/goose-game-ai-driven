class Game(private val diceRoller: () -> Dice = { roll() }) {
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

        val dice = diceRoller()
        player.move(dice.sum)

        val response = generateMoveMessage(player, dice)
        if (player.hasWon()) {
            return "$response. ${player.name} Wins!!"
        }
        return response
    }

    private fun generateMoveMessage(player: Player, dice: Dice): String =
        "${player.name} rolls ${dice.first}, ${dice.second}. ${player.name} moves from ${oldPositionName(player)} to " + when {
            player.bounced() -> bounceMessage(player)
            player.landedOnTheBridgeWith(dice) -> "The Bridge. ${player.name} jumps to ${player.getPosition()}"
            player.landedOnTheGooseWith(dice) -> "${player.getPosition() - dice.sum}, The Goose. ${player.name} moves again and goes to ${player.getPosition()}"
            else -> player.getPosition().toString()
        }

    private fun oldPositionName(player: Player) =
        if (player.wasAtStartPosition()) "Start" else player.getOldPosition().toString()

    private fun bounceMessage(player: Player) =
        "${63}. ${player.name} bounces! ${player.name} returns to ${player.getPosition()}"

    private fun Player.isAlreadyPresent() = players.any { it.name == name }

    private fun playersInGame() = players.joinToString(", ") { it.name }
}
