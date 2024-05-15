private const val START_POSITION = 0
private const val THE_BRIDGE = 6
private const val LAST_POSITION = 63

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
        }
    }

    fun getOldPosition(): Int = oldPosition

    fun getPosition(): Int = position

    fun wasAtStartPosition() = getOldPosition() == START_POSITION

    fun bounced(): Boolean = getPosition() < getOldPosition()

    fun hasWon(): Boolean = position == LAST_POSITION

    fun landedOnTheBridgeWith(dice: Dice): Boolean = oldPosition + dice.sum == THE_BRIDGE
}
