import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {
    private val dice = mockk<Dice>()
    private val game = Game(dice)

    @Test
    fun `when a player is added, the system should respond with the player's name`() {
        val response = game.addPlayer(Player("Pippo"))
        assertEquals("players: Pippo", response)
    }

    @Test
    fun `when an existing player is added again, the system should respond with an appropriate message`() {
        game.addPlayer(Player("Pippo"))
        val response = game.addPlayer(Player("Pippo"))
        assertEquals("Pippo: already existing player", response)
    }

    @Test
    fun `when a player moves, the system should update their position and respond with the appropriate message`() {
        val pippo = Player("Pippo")
        val pluto = Player("Pluto")

        game.addPlayer(pippo)
        game.addPlayer(pluto)

        every { dice.roll() } returns Pair(4, 2)
        var response = game.movePlayer(pippo)
        assertEquals("Pippo rolls 4, 2. Pippo moves from Start to 6", response)

        every { dice.roll() } returns Pair(1, 3)
        response = game.movePlayer(pluto)
        assertEquals("Pluto rolls 1, 3. Pluto moves from Start to 4", response)

        every { dice.roll() } returns Pair(3, 2)
        response = game.movePlayer(pippo)
        assertEquals("Pippo rolls 3, 2. Pippo moves from 6 to 11", response)
    }

    @Test
    fun `when a player lands on space 63, they win the game`() {
        val pippo = Player("Pippo")
        game.addPlayer(pippo)
        pippo.move(60) // Move Pippo to space 60

        every { dice.roll() } returns Pair(1, 2)
        val response = game.movePlayer(pippo)

        assertEquals("Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!", response)
    }

    @Test
    fun `the game takes care of rolling the dice for the player`() {
        val pippo = Player("Pippo")
        game.addPlayer(pippo)
        pippo.move(4) // Move Pippo to space 4

        every { dice.roll() } returns Pair(1, 2)
        val response = game.movePlayer(pippo)

        assertEquals("Pippo rolls 1, 2. Pippo moves from 4 to 7", response)
    }
}
