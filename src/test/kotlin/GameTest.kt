import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun `should add a player to the game`() {
        // Given
        val game = Game()

        // When
        game.addPlayer("Pippo")

        // Then
        assertEquals("players: Pippo", game.players())
    }

    @Test
    fun `should not allow duplicated players`() {
        // Given
        val game = Game()
        game.addPlayer("Pippo")

        // When
        val result = game.addPlayer("Pippo")

        // Then
        assertEquals("Pippo: already existing player", result)
    }

}
