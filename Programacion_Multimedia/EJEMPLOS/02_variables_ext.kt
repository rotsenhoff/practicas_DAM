fun main() {

    /*Hay dos formas de definir valores; con "val" de valor, por tanto inmutable y "var" de variable que puede modificar
    *su resultado*/

    // Números enteros
    val edad: Int = 25
    val poblacion: Long = 48_000_000L
    val temperatura: Short = -10
    val numeroPequeno: Byte = 100

    // Números decimales
    val precio: Float = 19.99f // los valores float llegan a 2^32
    val pi: Double = 3.1415926535 // los valores double llegan a 2^64

    // Booleano
    val esMayorDeEdad: Boolean = true

    // Carácter
    val inicial: Char = 'C' // con caracteres se usan comillas simples
    val saltoLinea: Char = '\n'

    // Texto
    val nombre: String = "César" // con strings se usan comillas dobles

    // Array
    val numeros: Array<Int> = arrayOf(10, 20, 30, 40, 50)

    // Objeto
    val persona: Persona = Persona("César", 51)

    // Mostrar los valores
    println("Int: $edad")
    println("Long: $poblacion")
    println("Short: $temperatura")
    println("Byte: $numeroPequeno")
    println("Float: $precio")
    println("Double: $pi")
    println("Boolean: $esMayorDeEdad")
    println("Char: $inicial")
    println("String: $nombre")
    println("Array: ${numeros.contentToString()}")
    println("Objeto: ${persona.nombre}, ${persona.edad} años")
}

// Creamos nuestro propio tipo de objeto
class Persona(
    val nombre: String,
    val edad: Int
)