// EJEMPLO 4: Propiedades, get y set personalizados

class Persona(val nombre: String, var edad: Int) {

    // Solo get: se calcula cada vez que se consulta, no se almacena
    val esMayorEdad
        get() = edad >= 18

    // Solo se puede cambiar desde dentro de la clase
    var sobrePeso = false
        private set

    // set personalizado: "field" es el campo de respaldo
    var peso = 0.0
        set(value) {
            field = value
            sobrePeso = value > 100
        }
}

class Termometro {
    var celsius = 20.0
        set(value) {
            // Validación: no existe nada por debajo del cero absoluto
            field = if (value < -273.15) -273.15 else value
        }

    val fahrenheit: Double
        get() = celsius * 9 / 5 + 32
}

fun main() {
    val pepe = Persona("Pepe", 40)
    pepe.peso = 101.0
    println("¿Sobrepeso?: ${if (pepe.sobrePeso) "SI" else "NO"}")
    println("¿Mayor de edad?: ${pepe.esMayorEdad}")

    pepe.edad = 15
    println("¿Mayor de edad ahora?: ${pepe.esMayorEdad}")

    // pepe.sobrePeso = false   // ERROR: el set es private

    val t = Termometro()
    t.celsius = 100.0
    println("100 C = ${t.fahrenheit} F")
    t.celsius = 0.0
    println("0 C = ${t.fahrenheit} F")
    t.celsius = -500.0
    println("Intento de -500 C, se queda en ${t.celsius}")
}
