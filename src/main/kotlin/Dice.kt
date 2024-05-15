fun roll(): Dice {
    val dice1 = (1..6).random()
    val dice2 = (1..6).random()
    return Dice(listOf(dice1, dice2))
}

data class Dice(private val results: List<Int> = emptyList()) {
    constructor(first: Int, second: Int) : this(listOf(first, second))

    val sum = results.sum()
    val first: Int = results[0]
    val second: Int = results[1]
}
