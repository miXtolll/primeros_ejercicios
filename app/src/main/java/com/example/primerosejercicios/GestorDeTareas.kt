package com.example.primerosejercicios

fun List<String>.pendientes(): List<String> {
    return this.filter { !it.startsWith("[X]") }
}

fun anadir(tareas: MutableList<String>, tarea: String) {
    tareas.add(tarea)
    println("Tarea añadida.")
}

fun completar(tareas: MutableList<String>, indice: Int) {

    val pos = indice - 1
    if (pos < 0 || pos >= tareas.size) {
        println("Indice no valido.")
    } else if (tareas[pos].startsWith("[X]")) {
        println("Esa tarea ya estaba completada.")
    } else {
        tareas[pos] = "[X] " + tareas[pos]
        println("Tarea completada.")
    }
}

fun listar(tareas: List<String>) {
    if (tareas.isEmpty()) {
        println("No hay tareas.")
    } else {
        for (i in tareas.indices) {
            println("${i + 1}. ${tareas[i]}")
        }
    }
}

fun main() {
    val tareas = mutableListOf<String>()
    var opcion = 0

    while (opcion != 5) {
        println()
        println("===== GESTOR DE TAREAS =====")
        println("1. Añadir tarea")
        println("2. Completar tarea")
        println("3. Listar tareas")
        println("4. Ver pendientes")
        println("5. Salir")
        print("Elige una opcion: ")

        opcion = readLine()!!.toInt()

        when (opcion) {
            1 -> {
                print("Escribe la tarea: ")
                val tarea = readLine()!!
                anadir(tareas, tarea)
            }
            2 -> {
                listar(tareas)
                print("Numero de la tarea a completar: ")
                val indice = readLine()!!.toInt()
                completar(tareas, indice)
            }
            3 -> listar(tareas)
            4 -> {
                val pendientes = tareas.pendientes()
                if (pendientes.isEmpty()) {
                    println("No hay tareas pendientes.")
                } else {
                    for (i in pendientes.indices) {
                        println("${i + 1}. ${pendientes[i]}")
                    }
                }
            }
            5 -> println("Hasta luego!")
            else -> println("Opcion no valida.")
        }
    }
}