// EJEMPLO 6: Interfaces
// Una clase solo hereda de UNA clase, pero puede implementar VARIAS interfaces

interface Volador {
    val altitudMaxima: Int                 // propiedad abstracta

    val esDeAltura: Boolean                // propiedad con accesor (sin campo de respaldo)
        get() = altitudMaxima > 300

    fun volar()                            // método abstracto

    fun aterrizar() {                      // método con implementación por defecto
        println("Aterrizando...")
    }
}

interface Nadador {
    fun nadar()
}

open class Ave(val nombre: String)

class Pato(nombre: String) : Ave(nombre), Volador, Nadador {
    override val altitudMaxima = 500
    override fun volar() = println("$nombre vuela hasta $altitudMaxima m")
    override fun nadar() = println("$nombre nada en el estanque")
}

// Un dron no es un ave, pero también vuela: ahí brillan las interfaces
class Dron(val id: Int) : Volador {
    override val altitudMaxima = 120
    override fun volar() = println("Dron $id volando a $altitudMaxima m")

    // Podemos sobrescribir también lo que ya tiene implementación
    override fun aterrizar() = println("Dron $id aterrizando en su base")
}

fun main() {
    // La interfaz se usa como tipo: no importa qué clase concreta sea
    val voladores: List<Volador> = listOf(Pato("Donald"), Dron(7))

    for (v in voladores) {
        v.volar()
        println("¿Vuela alto?: ${v.esDeAltura}")
        v.aterrizar()
        println("---")
    }

    Pato("Lucas").nadar()
}
