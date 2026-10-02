package com.example.primerosejercicios

fun main() {
    print("Escribe un texto: ")
    val texto = readLine()!!.lowercase()

    val frecuencias = mutableMapOf<Char, Int>()


    for (c in texto) {

        if (c.isLetter()) {
            if (frecuencias.containsKey(c)) {
                frecuencias[c] = frecuencias[c]!! + 1
            } else {
                frecuencias[c] = 1
            }
        }
    }

    if (frecuencias.isEmpty()) {
        println("No hay letras en el texto.")
    } else {

        val ordenado = frecuencias.toList().sortedByDescending { it.second }

        println()
        println("Frecuencia de letras:")
        for (par in ordenado) {
            println("${par.first} -> ${par.second}")
        }
    }
}