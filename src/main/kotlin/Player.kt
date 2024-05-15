data class Player(val name: String, private var position: Int = 0) {
    fun move(roll: Int) {
        position = (position + roll) % (63 + 1)
        if (position == THE_BRIDGE) {
            position = 12
        }
    }

    fun getPosition(): Int = position

    fun hasWon(): Boolean = position == 63
}
