package com.example.primerosejercicios

fun calificacion(media: Double): String {
    return when {
        media < 5 -> "Suspenso"
        media < 7 -> "Aprobado"
        media < 9 -> "Notable"
        else -> "Sobresaliente"
    }
}

fun main() {
    // Texto simulado del CSV
    val texto = "nombre,mates,lengua,ingles\n" +
            "Francisco Vela,8,9,10\n" +
            "Adrian Sanchez,4,3,5\n" +
            "Pedro Chicon,6,7,6\n" +
            "Juan Diaz,9,10,9\n" +
            "Daniel Garcia,5,5,6"

    // 1. Dividimos el texto en lineas
    val lineas = texto.split("\n")

    // 2. La primera linea son los encabezados
    val encabezados = lineas[0].split(",")
    println("Asignaturas: ${encabezados[1]}, ${encabezados[2]}, ${encabezados[3]}")
    println("-----------------------------------------------")

    // 3. Recorremos los alumnos (desde la linea 1, saltando los encabezados)
    for (i in 1 until lineas.size) {
        val campos = lineas[i].split(",")

        val nombre = campos[0]
        var suma = 0.0
        var notas = ""

        // Las notas empiezan en la posicion 1
        for (j in 1 until campos.size) {
            val nota = campos[j].toDouble()
            suma += nota
            notas += "$nota "
        }

        val media = suma / (campos.size - 1)

        // 4. Mostramos el listado
        println("Nombre: $nombre | Notas: $notas| Media: $media | Calificacion: ${calificacion(media)}")
    }
}