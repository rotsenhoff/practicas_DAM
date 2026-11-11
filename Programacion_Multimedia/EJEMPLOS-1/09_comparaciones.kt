// EJEMPLO 9: Comparaciones. == (igualdad estructural) frente a === (misma referencia)

class Punto(val x: Int, val y: Int)

// Aquí sobrescribimos equals para definir "igual" según el contenido
class PuntoComparable(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is PuntoComparable) return false
        return x == other.x && y == other.y
    }

    // Regla de oro: si sobrescribes equals, sobrescribe hashCode
    override fun hashCode(): Int = 31 * x + y
}

fun main() {
    // Con String == compara el contenido
    val s1 = "kot" + "lin"
    val s2 = StringBuilder("kot").append("lin").toString()
    println(s1 == s2)      // true: mismo contenido
    println(s1 === s2)     // false: objetos distintos en memoria

    // Con nuestras clases, == llama a equals() de Any (por defecto compara referencias)
    val p1 = Punto(1, 2)
    val p2 = Punto(1, 2)
    println(p1 == p2)      // false: no hemos definido equals
    println(p1 === p2)     // false
    println(p1 == p1)      // true

    // Ahora con equals sobrescrito
    val q1 = PuntoComparable(1, 2)
    val q2 = PuntoComparable(1, 2)
    println(q1 == q2)      // true: mismo contenido
    println(q1 === q2)     // false: siguen siendo dos objetos

    // == es seguro con null: no lanza excepción
    println(comparar(null, null))      // true
    println(comparar(null, "hola"))    // false
    println(comparar("hola", "hola"))  // true
}

fun comparar(a: String?, b: String?): Boolean = a == b
