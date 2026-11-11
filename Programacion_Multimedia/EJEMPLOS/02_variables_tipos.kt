fun main() {
    val nombre = "Lucia"      // solo lectura
    var puntos = 0            // mutable
    val edad: Int = 20
    val precio = 12.99        // Double por inferencia
    val activo = true         // Boolean

    puntos += 10

    println("Nombre: $nombre")
    println("Edad: $edad")
    println("Precio: $precio")
    println("Activo: $activo")
    
    println("Puntos: $puntos")
    println("Puntos: " + puntos) /*Es exactamente lo mismo. El simbolo de $ sirve para
    incluir el valor de una variable dentro de dobles comillas. En Kotlin a esto se le llama "plantillas"*/
}

