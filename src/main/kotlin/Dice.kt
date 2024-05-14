class Dice {
    fun roll(): Int {
        val dice1 = (1..6).random()
        val dice2 = (1..6).random()
        return dice1 + dice2
    }
}
