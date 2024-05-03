import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `add a new player to the game`() {
        val game = Game()
        game.addPlayer("Pippo")
        assertEquals("players: Pippo", game.playersList())
    }

    @Test
    fun `adding a duplicate player does not alter the player list`() {
        val game = Game()
        game.addPlayer("Pippo")
        game.addPlayer("Pippo") // Attempt to add a duplicate
        assertEquals("players: Pippo", game.playersList())
    }
}
