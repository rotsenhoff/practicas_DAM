/*
Ejercicio 02: Conversor de minutos
Tema: Variables y operadores
Objetivo: Convierte 135 minutos en horas completas y minutos restantes usando / y %.
Pensado para Kotlin Playground.
*/

fun main() {
    val minutosTotales = 135
    // TODO: calcula horas y minutos restantes

    /*SOLUCION*/

     val horas = minutosTotales / 60
    val decimal = minutosTotales % 60
    
    println ("$horas,$decimal")
}
