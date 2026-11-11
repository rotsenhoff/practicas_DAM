// EJEMPLO 8: Tipos anulables, acceso seguro (?.) y operador Elvis (?:)

class Contacto(val nombre: String, val email: String?)

// El ? tras el tipo lo hace anulable
fun longitud(texto: String?): Int? = texto?.length          // acceso seguro

fun longitudOCero(texto: String?): Int = texto?.length ?: 0 // Elvis: valor por defecto

fun imprimirSiHay(texto: String?) {
    if (texto != null) {
        // Smart cast: tras comprobar != null el compilador ya sabe que no es null
        println("Con texto: ${texto.length} letras")
    } else {
        println("No hay texto")
    }
}

// El ejemplo del temario: dividir usando 1 si no nos dan divisor
fun dividir(a: Int, c: Int?): Int = a / (c ?: 1)

fun main() {
    // 1. Tipo no anulable
    val sinNulos: String = "hola"
    println(sinNulos)
    // val error: String = null   // ERROR: Null can not be a value of a non-null type String

    // 2. Acceso seguro y Elvis
    println(longitud(null))          // null (no explota)
    println(longitud("Kotlin"))      // 6
    println(longitudOCero(null))     // 0
    println(longitudOCero("Kotlin")) // 6

    imprimirSiHay("Kotlin")
    imprimirSiHay(null)

    // 3. Caso real: un mapa devuelve null si la clave no existe
    val telefonos = mapOf("Ana" to "600111222", "Pepe" to "611333444")
    val buscado = telefonos["Luis"]
    println("Teléfono de Luis: ${buscado ?: "no registrado"}")

    // 4. Propiedades anulables en una clase
    val marta = Contacto("Marta", null)
    println("Email: ${marta.email ?: "sin email"}")
    println("Dominio: ${marta.email?.substringAfter("@")}")  // null

    // ?.let ejecuta el bloque solo si NO es null
    marta.email?.let { println("Enviando correo a $it") }    // no hace nada

    val luis = Contacto("Luis", "luis@itecam.com")
    luis.email?.let { println("Enviando correo a $it") }

    // 5. Elvis con la división
    println("Primera division: ${dividir(21, null)}")   // 21 / 1 = 21
    println("Segunda division: ${dividir(21, 7)}")      // 21 / 7 = 3

    // 6. Un anulable solo se puede asignar a otro anulable
    val largo: Int? = longitud("Kotlin")
    // val seguro: Int = longitud("Kotlin")   // ERROR: Int? no cabe en Int
    println(largo)
}
