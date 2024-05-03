class Game {
    private val playerList = mutableListOf<String>()

    fun addPlayer(name: String): String? {
        return if (playerList.contains(name)) {
            "$name: already existing player"
        } else {
            playerList.add(name)
            null
        }
    }

    fun players(): String {
        return "players: ${playerList.joinToString(", ")}"
    }
}
