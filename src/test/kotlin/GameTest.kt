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

        var response = game.movePlayer("Pippo", 4, 2)
        assertEquals("Pippo rolls 4, 2. Pippo moves from Start to 6", response)

        response = game.movePlayer("Pluto", 2, 2)
        assertEquals("Pluto rolls 2, 2. Pluto moves from Start to 4", response)

        response = game.movePlayer("Pippo", 2, 3)
        assertEquals("Pippo rolls 2, 3. Pippo moves from 6 to 11", response)
    }
}
