// EJEMPLO 7: Clases abstractas
// No se pueden instanciar. Los miembros abstractos se implementan en las hijas

abstract class Figura(val nombre: String) {
    abstract val lados: Int                // sin implementación
    abstract fun area(): Double            // sin implementación

    // Miembro normal: ya está implementado y lo heredan todas
    fun describir() = "$nombre: $lados lados, área ${area()}"
}

// No hace falta "open" en la clase abstracta para heredar de ella
class Rectangulo(val base: Double, val altura: Double) : Figura("Rectángulo") {
    override val lados = 4
    override fun area() = base * altura
}

class Cuadrado(val lado: Double) : Figura("Cuadrado") {
    override val lados = 4
    override fun area() = lado * lado
}

class Circulo(val radio: Double) : Figura("Círculo") {
    override val lados = 0
    override fun area() = Math.PI * radio * radio
}

fun main() {
    // val f = Figura("Genérica")   // ERROR: Cannot create an instance of an abstract class

    val figuras = listOf(Rectangulo(3.0, 4.0), Cuadrado(5.0), Circulo(2.0))

    for (f in figuras) {
        println(f.describir())
    }

    // Polimorfismo otra vez: buscamos la figura de mayor área
    val mayor = figuras.maxByOrNull { it.area() }
    println("La mayor es: ${mayor?.nombre}")
}
