data class Player(val name: String, private var position: Int = 0) {
    fun move(roll: Int) {
        position += roll
    }

    fun getPosition(): Int {
        return position
    }

    fun hasWon(): Boolean {
        return position == 63
    }
}
