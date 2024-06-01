import Classes.Character
import Classes.Stats

import java.util.Scanner
import java.time.LocalDate
import java.time.format.DateTimeParseException

fun main () {
    val crudOperations = crudOperations()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nCharacter Management System")
        println("1. Create character")
        println("2. View all characters")
        println("3. View character by name")
        println("4. Update character by name")
        println("5. Delete character by name")
        println("6. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> {
                println("Enter character details:")
                scanner.nextLine() // New line for data
                // Setting properties for character
                print("Name: ")
                val name = scanner.nextLine()

                print("Gender: ")
                val gender = scanner.nextLine()

                print("Age: ")
                val age = scanner.nextLine().toInt()

                var birthday: LocalDate
                while (true) {
                    print("Birthday (YYYY-MM-DD): ")
                    val birthdayInput = scanner.nextLine()
                    try {
                        birthday = LocalDate.parse(birthdayInput)
                        break
                    } catch (e: DateTimeParseException) {
                        println("Invalid date format. Please enter in YYYY-MM-DD format.")
                    }
                }

                print("Difficulty: ")
                val difficulty = scanner.nextLine().toDouble()

                print("Playable: ")
                val playable = scanner.nextLine().toBoolean()

                print("Guild: ")
                val guild = scanner.nextLine()

                print("Attack damage: ")
                val atk = scanner.nextLine().toInt()

                print("Defense: ")
                val def = scanner.nextLine().toInt()

                print("Speed: ")
                val speed = scanner.nextLine().toDouble()

                print("Lucky: ")
                val lucky = scanner.nextLine().toBoolean()

                val character = Character(name, gender, age, birthday, difficulty, playable,
                    Stats(
                        guild, atk, def, speed, lucky
                    )
                )
                crudOperations.createCharacter(character)
                println("Character created successfully")
            }
            2 -> {
                val characters = crudOperations.getAllCharacters()
                println("All characters: ")
                characters.forEach { println(it) }
            }
            3 -> {
                print("Enter character name to search: ")
                scanner.nextLine()
                val name = scanner.nextLine()
                val character = crudOperations.getCharacter(name)
                if (character != null) {
                    println("Character found: $character")
                } else {
                    println("Character not found")
                }
            }
            4 -> {
                print("Enter character name to update: ")
                scanner.nextLine()
                val name = scanner.nextLine()
                val character = crudOperations.getCharacter(name)
                if(character != null) {
                    println("Enter updated character info:")

                    print("New difficulty: ")
                    val newDiff = scanner.nextLine().toDouble()

                    print("Playable: ")
                    val newPlayable = scanner.nextLine().toBoolean()

                    print("Attack update: ")
                    val newAtk = scanner.nextLine().toInt()

                    print("Defense update: ")
                    val newDef = scanner.nextLine().toInt()

                    print("Speed update: ")
                    val newSpeed = scanner.nextLine().toDouble()

                    print("Lucky update: ")
                    val newLucky = scanner.nextLine().toBoolean()

                    val updatedCharacter = character.copy(
                        difficulty = newDiff,
                        playable = newPlayable,
                        stats = Stats(guild = character.stats.guild, atk = newAtk, def = newDef, speed = newSpeed, lucky = newLucky)
                    )
                    crudOperations.updateCharacter(name, updatedCharacter)
                    println("Character updated successfully")
                } else {
                    println("Character not found")
                }
            }
            5 -> {
                print("Enter character name to delete: ")
                scanner.nextLine()
                val name = scanner.nextLine()
                if (crudOperations.deleteCharacter(name)) {
                    println("Character deleted successfully")
                } else {
                    println("Character not found")
                }
            }
            6 -> {
                println("Exiting the system")
                break
            }
            else -> {
                println("Invalid choice. Please try again")
            }
        }
    }
}