fun main() {
    val a = 10
    val b = 3

    println("Suma: ${a + b}")
    println("Resto: ${a % b}")
    println("a > b: ${a > b}")
    println("a == b: ${a == b}")

    val puedeEntrar = a > b && b > 0
    println("Puede entrar: $puedeEntrar")
}
