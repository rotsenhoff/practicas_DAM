class Persona(
    val nombre: String,
    val edad: Int
) {
    // Propiedad que NO está en el constructor
    //var ciudad: String = "Madrid"

    fun presentarse() {
        println("Hola, soy $nombre y tengo $edad años.")
    }
}

fun main() {

    // Creamos dos objetos de la clase Persona
    val persona1 = Persona("Carlos", 25)
    val persona2 = Persona("Ana", 30)

    // Usamos los objetos
    persona1.presentarse()
    persona2.presentarse()
}