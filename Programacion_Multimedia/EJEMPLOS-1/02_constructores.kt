// EJEMPLO 2: Constructor primario, bloque init y constructor secundario
import java.util.UUID

class Coche(val matricula: String, val marca: String) {

    // Se inicializa al crear el objeto (en orden de aparición con los init)
    var numeroSerie = UUID.randomUUID().toString()

    // Lógica extra del constructor primario: aquí podemos validar
    init {
        require(matricula.isNotBlank()) { "La matrícula no puede estar vacía" }
        println("init: creando $marca con matrícula $matricula")
    }

    // Constructor secundario: DEBE delegar en el primario con this(...)
    constructor(numeroSerie: String, matricula: String, marca: String) : this(matricula, marca) {
        this.numeroSerie = numeroSerie
        println("secundario: número de serie fijado a $numeroSerie")
    }
}

fun main() {
    val tucson = Coche("7777MWT", "Hyundai")
    println("Serie aleatoria: ${tucson.numeroSerie}")

    val ibiza = Coche("SN-0001", "1234ABC", "Seat")
    println("Serie manual: ${ibiza.numeroSerie}")

    // Observa el orden de los mensajes: primero init, luego el cuerpo del secundario

    // Descomenta para ver la validación del init:
    // val malo = Coche("", "Ford")   // IllegalArgumentException
}
