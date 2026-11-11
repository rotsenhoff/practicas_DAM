// EJEMPLO 1: Clases y objetos


// Clase mínima: sin cuerpo y sin constructor explícito
class Programador

// Clase con constructor primario. val/var crean propiedades automáticamente
class Libro(val titulo: String, val autor: String, var paginas: Int)

fun main() {
    // No existe "new": se llama al constructor como a una función
    val p1 = Programador()
    println(p1) // Usa el toString() de Any, sale algo tipo Programador@1b2c3d

    val libro = Libro("El Quijote", "Cervantes", 1100)
    println("${libro.titulo} de ${libro.autor}, ${libro.paginas} páginas")

    // La variable es val (no se puede reasignar), pero el objeto es mutable
    libro.paginas = 1200
    println("Ahora tiene ${libro.paginas} páginas")

    // Prueba a descomentar estas dos líneas y lee el error del compilador:
    // libro = Libro("Otro", "Otro", 10)   // Val cannot be reassigned
    // libro.titulo = "Otro título"        // titulo es val: no tiene set
}
