package com.example.a2024accgr1giso

class BBaseDatosMemoria {
    companion object{
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1, "Glenn", "a@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2, "Isaac", "b@a.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3, "Salcedo", "c@a.com")
                )
        }
    }
}