/*
Ejercicio 03: Consumo medio
Tema: Double y operadores
Objetivo: Calcula el consumo medio en L/100 km si un coche usa 32.5 L para recorrer 460 km.
Pensado para Kotlin Playground.
*/

fun main() {
    val litros = 32.5
    val kilometros = 460.0
    // TODO: consumo = litros / kilometros * 100

     var consumoMedio = 100 * litros / kilometros
    
    println("El consumo de litros a los 100 km es de $consumoMedio l/100km")
}
