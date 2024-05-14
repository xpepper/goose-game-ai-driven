import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {
    private val game = Game()

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
        game.addPlayer(Player("Pippo"))
        game.addPlayer(Player("Pluto"))

        val dice = mockk<Dice>()
        every { dice.roll() } returns 6
        var response = game.movePlayer("Pippo", dice)
        assertEquals("Pippo rolls 6. Pippo moves from Start to 6", response)

        every { dice.roll() } returns 4
        response = game.movePlayer("Pluto", dice)
        assertEquals("Pluto rolls 4. Pluto moves from Start to 4", response)

        every { dice.roll() } returns 5
        response = game.movePlayer("Pippo", dice)
        assertEquals("Pippo rolls 5. Pippo moves from 6 to 11", response)
    }

    @Test
    fun `when a player lands on space 63, they win the game`() {
        val pippo = Player("Pippo")
        game.addPlayer(pippo)
        pippo.move(60) // Move Pippo to space 60

        val dice = mockk<Dice>()
        every { dice.roll() } returns 3
        val response = game.movePlayer("Pippo", dice)

        assertEquals("Pippo rolls 3. Pippo moves from 60 to 63. Pippo Wins!!", response)
    }

    @Test
    fun `when a player rolls a number that would move them beyond space 63, they bounce back off the end of the track`() {
        val pippo = Player("Pippo")
        game.addPlayer(pippo)
        pippo.move(60) // Move Pippo to space 60

        val dice = mockk<Dice>()
        every { dice.roll() } returns 5
        val response = game.movePlayer("Pippo", dice)

        assertEquals("Pippo rolls 5. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 62", response)
    }
}
