data class Player(val name: String, private var position: Int = 0) {
    fun move(roll: Int) {
        val newPosition = position + roll
        position = if (newPosition > 63) 63 - (newPosition - 63) else newPosition
    }

    fun getPosition(): Int {
        return position
    }

    fun hasWon(): Boolean {
        return position == 63
    }
}
