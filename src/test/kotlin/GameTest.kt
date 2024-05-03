import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `add a new player to the game`() {
        val game = Game()
        game.addPlayer("Pippo")
        assertEquals("players: Pippo", game.playersList())
    }
}
