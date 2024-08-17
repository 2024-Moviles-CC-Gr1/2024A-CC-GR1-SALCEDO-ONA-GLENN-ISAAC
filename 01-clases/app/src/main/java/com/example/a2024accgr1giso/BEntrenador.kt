package com.example.a2024accgr1giso

class BEntrenador(
    var id: Int,
    var nombre: String,
    var descripcion: String?
) {
    override fun toString(): String {
        return "$nombre $descripcion" //También se puede poner con llaves
    }
}