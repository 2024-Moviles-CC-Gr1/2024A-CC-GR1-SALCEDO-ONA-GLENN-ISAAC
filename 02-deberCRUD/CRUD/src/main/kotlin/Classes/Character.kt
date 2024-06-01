package Classes

import java.time.LocalDate

data class Character(
    val name: String,
    val gender: String,
    val age: Int,
    val birthday: LocalDate,
    val difficulty: Double,
    val playable: Boolean,
    val stats: Stats
    )