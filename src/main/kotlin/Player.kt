private const val START_POSITION = 0
private const val THE_BRIDGE = 6
private const val THE_BRIDGE_DESTINATION = 12
private const val LAST_POSITION = 63
private val THE_GOOSE = listOf(5, 9, 14, 18, 23, 27)

data class Player(val name: String) {
    private val moves = mutableListOf(START_POSITION)

    fun move(roll: Int) {
        when (val position = position() + roll) {
            THE_BRIDGE -> moves.add(THE_BRIDGE_DESTINATION)
            in THE_GOOSE -> moves.add(position + roll)
            else -> moves.add(position)
        }
    }

    fun moves(): List<Int> = moves.toList()

    fun position(): Int = moves.last()

    fun previousPosition(): Int = moves.secondToLast()

    fun wasAtStartPosition() = previousPosition() == START_POSITION

    fun bounced(): Boolean = position() < previousPosition()

    fun hasWon(): Boolean = position() == LAST_POSITION

    fun landedOnTheBridgeWith(dice: Dice): Boolean = previousPosition() + dice.sum == THE_BRIDGE

    fun landedOnTheGooseWith(dice: Dice): Boolean = previousPosition() + dice.sum in THE_GOOSE
}

private fun List<Int>.secondToLast() = takeLast(2).first()
