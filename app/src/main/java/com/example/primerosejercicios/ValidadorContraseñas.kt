package com.example.primerosejercicios

fun validar(contrasena: String): List<String> {
    val errores = mutableListOf<String>()

    if (contrasena.length < 8) {
        errores.add("Debe tener al menos 8 caracteres.")
    }
    if (!contrasena.any { it.isUpperCase() }) {
        errores.add("Debe tener al menos una mayuscula.")
    }
    if (!contrasena.any { it.isLowerCase() }) {
        errores.add("Debe tener al menos una minuscula.")
    }
    if (!contrasena.any { it.isDigit() }) {
        errores.add("Debe tener al menos un digito.")
    }
    if (!contrasena.any { !it.isLetterOrDigit() }) {
        errores.add("Debe tener al menos un caracter especial.")
    }

    return errores
}

fun main() {
    print("Introduce una contraseña: ")
    val contrasena = readLine()!!

    val errores = validar(contrasena)

    if (errores.isEmpty()) {
        println("Contraseña valida.")
    } else {
        println("Contraseña no valida:")
        for (error in errores) {
            println("- $error")
        }
    }
}