// EJEMPLO 5: Herencia y polimorfismo
// Recuerda: en Kotlin las clases son final por defecto, hay que marcar open

open class Animal(val nombre: String) {
    open val patas = 4                    // propiedad sobrescribible
    open fun sonido() = "..."             // método sobrescribible

    fun presentarse() = "Soy $nombre, tengo $patas patas y hago: ${sonido()}"

    // toString viene de Any, por eso lleva override
    override fun toString() = "Animal($nombre)"
}

class Perro(nombre: String) : Animal(nombre) {
    override fun sonido() = "Guau"
}

class Gato(nombre: String) : Animal(nombre) {
    override fun sonido() = "Miau"
}

class Pajaro(nombre: String) : Animal(nombre) {
    override val patas = 2
    override fun sonido() = "Pio"
}

// Herencia con constructor secundario en la hija
open class Vehiculo(val marca: String, val modelo: String)

class Moto : Vehiculo {
    constructor(marca: String, modelo: String) : super(marca, modelo)
}

fun main() {
    // Polimorfismo: una lista de Animal con objetos de distintas hijas
    val animales: List<Animal> = listOf(Perro("Rex"), Gato("Tom"), Pajaro("Piolín"))

    for (a in animales) {
        println(a.presentarse())   // cada uno responde con su sonido()
    }

    println(animales)              // usa el toString sobrescrito

    // Comprobación de tipo
    for (a in animales) {
        if (a is Perro) println("${a.nombre} es un perro")
    }

    // equals de Any compara referencias por defecto
    println(Perro("Rex") == Perro("Rex"))   // false: son dos objetos distintos

    val moto = Moto("Yamaha", "MT-07")
    println("${moto.marca} ${moto.modelo}")

    // class Cachorro : Perro("Toby")  // ERROR: Perro es final, no es open
}
