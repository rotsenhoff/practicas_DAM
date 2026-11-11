// EJEMPLO 3: Modificadores de visibilidad
// private, protected, internal, public (por defecto)

open class Termostato {
    private var temperaturaInterna = 20   // solo esta clase
    protected var margen = 2              // esta clase y sus hijas
    internal var modelo = "T-100"         // todo el módulo
    var nombre = "Salón"                  // public: visible en todas partes

    fun subir() {
        temperaturaInterna++
    }

    fun leer(): Int = temperaturaInterna
}

class TermostatoPro : Termostato() {
    fun ajustarMargen() {
        margen = 5                        // OK: protected se ve desde la hija
        // temperaturaInterna = 30        // ERROR: es private en el padre
    }

    fun verMargen(): Int = margen
}

// Constructor privado: nadie fuera de la clase puede hacer Sesion("x")
class Sesion private constructor(val usuario: String) {
    companion object {
        // Un companion object permite llamar a Sesion.iniciar(...)
        // (lo veremos con más detalle más adelante)
        fun iniciar(usuario: String) = Sesion(usuario)
    }
}

fun main() {
    val t = Termostato()
    t.subir()
    println("Temperatura: ${t.leer()}")
    println("${t.nombre} / ${t.modelo}")

    // Descomenta cada línea y mira el error:
    // println(t.temperaturaInterna)   // Cannot access: it is private
    // println(t.margen)               // Cannot access: it is protected

    val pro = TermostatoPro()
    pro.ajustarMargen()
    println("Margen del pro: ${pro.verMargen()}")

    val s = Sesion.iniciar("miguel")
    println("Sesión de ${s.usuario}")
    // val s2 = Sesion("otro")         // Cannot access '<init>': it is private
}
