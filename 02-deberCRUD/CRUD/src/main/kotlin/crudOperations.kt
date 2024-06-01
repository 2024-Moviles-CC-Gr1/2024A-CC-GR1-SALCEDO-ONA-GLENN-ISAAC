import Classes.Character

class crudOperations {
    val characters = mutableListOf<Character>()

    // Creating characters
    fun createCharacter(character: Character) {
        characters.add(character)
    }

    // Reading all characters
    fun getAllCharacters(): List<Character> {
        return characters
    }

    // Reading character by name
    fun getCharacter(name: String): Character? {
        return characters.find { it.name.equals(name, ignoreCase = true) }
    }

    // Updating character
    fun updateCharacter(name: String, updatedCharacter: Character): Boolean {
        val index = characters.indexOfFirst { it.name.equals(name, ignoreCase = true) }
        return if (index != -1) {
            characters[index] = updatedCharacter
            true
        } else {
            false
        }
    }

    // Deleting character
    fun deleteCharacter(name: String): Boolean {
        return characters.removeIf { it.name.equals(name, ignoreCase = true) }
    }
}