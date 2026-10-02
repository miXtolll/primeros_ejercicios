package com.example.primerosejercicios

fun mostrarMapa(asientos: Map<String, Any>) {
    println()
    println("        PANTALLA")
    println("    1   2   3   4   5")
    for (fila in 'A'..'E') {
        print("$fila  ")
        for (num in 1..5) {
            // as? devuelve null si no se puede convertir; ?: da un valor por defecto
            val ocupado = asientos["$fila$num"] as? Boolean ?: false
            if (ocupado) {
                print("[X] ")
            } else {
                print("[ ] ")
            }
        }
        println()
    }
    println("[ ] libre   [X] ocupado")
}

fun reservar(asientos: MutableMap<String, Any>, clave: String) {
    val estado = asientos[clave] as? Boolean

    if (estado == null) {
        println("El asiento $clave no existe.")
    } else if (estado) {
        println("El asiento $clave ya esta ocupado.")
    } else {
        asientos[clave] = true
        println("Asiento $clave reservado.")
    }
}

fun cancelar(asientos: MutableMap<String, Any>, clave: String) {
    val estado = asientos[clave] as? Boolean

    if (estado == null) {
        println("El asiento $clave no existe.")
    } else if (!estado) {
        println("El asiento $clave no estaba reservado.")
    } else {
        asientos[clave] = false
        println("Reserva del asiento $clave cancelada.")
    }
}

fun main() {
    val asientos = mutableMapOf<String, Any>()

    // Rellenamos A1..E5 como disponibles (false)
    for (fila in 'A'..'E') {
        for (num in 1..5) {
            asientos["$fila$num"] = false
        }
    }

    var opcion = 0

    while (opcion != 4) {
        println()
        println("===== CINE =====")
        println("1. Mostrar mapa")
        println("2. Reservar asiento")
        println("3. Cancelar reserva")
        println("4. Salir")
        print("Elige una opcion: ")

        try {
            // ?: evita el null si readLine() no devuelve nada
            opcion = (readLine() ?: "").toInt()
        } catch (e: NumberFormatException) {
            println("Debes escribir un numero.")
            opcion = 0
            continue
        }

        when (opcion) {
            1 -> mostrarMapa(asientos)
            2 -> {
                mostrarMapa(asientos)
                print("Asiento a reservar (ej: A1): ")
                val clave = (readLine() ?: "").trim().uppercase()
                reservar(asientos, clave)
            }
            3 -> {
                print("Asiento a cancelar (ej: A1): ")
                val clave = (readLine() ?: "").trim().uppercase()
                cancelar(asientos, clave)
            }
            4 -> println("Hasta luego!")
            else -> println("Opcion no valida.")
        }
    }
}