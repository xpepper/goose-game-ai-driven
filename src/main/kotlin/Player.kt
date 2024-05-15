private const val START_POSITION = 0
private const val THE_BRIDGE = 6
private const val LAST_POSITION = 63
private val THE_GOOSE = listOf(5, 9, 14, 18, 23, 27)

data class Player(
    val name: String,
    private var position: Int = START_POSITION,
    private var oldPosition: Int = START_POSITION
) {
    fun move(roll: Int) {
        oldPosition = position
        position = (position + roll) % (LAST_POSITION + 1)
        if (position == THE_BRIDGE) {
            position = 12
        } else if (position in THE_GOOSE) {
            position += roll
        }
    }

    fun getOldPosition(): Int = oldPosition

    fun getPosition(): Int = position

    fun wasAtStartPosition() = getOldPosition() == START_POSITION

    fun bounced(): Boolean = getPosition() < getOldPosition()

    fun hasWon(): Boolean = position == LAST_POSITION

    fun landedOnTheBridgeWith(dice: Dice): Boolean = oldPosition + dice.sum == THE_BRIDGE

    fun landedOnTheGooseWith(dice: Dice): Boolean = oldPosition + dice.sum in THE_GOOSE
}
