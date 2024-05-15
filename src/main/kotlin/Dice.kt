class Dice {
    fun roll(): Pair<Int, Int> {
        val dice1 = (1..6).random()
        val dice2 = (1..6).random()
        return Pair(dice1, dice2)
    }
}
