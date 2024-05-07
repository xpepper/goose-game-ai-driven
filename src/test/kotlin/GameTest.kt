import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `when a player is added, the system should respond with the player's name`() {
        val game = Game()
        val response = game.addPlayer(Player("Pippo"))
        assertEquals("players: Pippo", response)
    }
}
