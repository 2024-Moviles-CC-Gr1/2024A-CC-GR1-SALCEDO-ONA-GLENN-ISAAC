import java.util.Date

fun main(){
    println("Hola mundo")
    //INMUTABLES (No se REASIGNA "=")
    val inmutable: String = "Glenn"
    //inmutable = "Isaac" // ERROR!!
    //MUTABLES
    var mutable: String = "Glenn"
    mutable = "Isaac" // OK
    // VAL > VAR
    // Duck Typing: Si se ve, suena y parece un pato, es un pato
    val ejemploVariable = "Adrian Eguez" //Se ve como un string, entonces es string
    val edadEjemplo: Int = 12
    ejemploVariable.trim()
    //ejemploVariable = edadEjemplo //ERROR!!
    //Variables primitivas
    val nombreProfesor: String = "Profesor"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'C'
    val mayorEdad: Boolean = true
    //Clases en Java
    val fechaNacimiento: Date = Date()

    //when (switch)
    val estadoCivilWhen = "C"
    when (estadoCivilWhen){
        ("C") -> {
            println("Casado")
        }
        "s" -> {
            println("Soltero")
        }
        else -> {
            println("No sabemos")
        }
    }
    val esSoltero = (estadoCivilWhen == "S")
    val coqueteo = if (esSoltero) "Si" else "No" // if else chiquito

    calcularSueldo(10.00)
    calcularSueldo(10.00,15.00,20.00)
    // Named parameters: No hay necesidad de respetar el orden de la función si lo hacemos con named parameters
    // calcularSueldo(sueldo, tasa, bonoEspecial)
    calcularSueldo(10.00, bonoEspecial = 20.00)
    calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00, tasa = 14.00)

    val sumaUno = Suma(1,1) // Es como el new Suma pero no hay la palabra reservada new
    val sumaDos = Suma(null,1)
    val sumaTres = Suma(1,null)
    val sumaCuatro = Suma(null,null)
    sumaUno.sumar()
    sumaDos.sumar()
    sumaTres.sumar()
    sumaCuatro.sumar()
    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSumas)
    // Arreglos
    // Estaticos
    val arregloEstatico: Array<Int> = arrayOf<Int>(1,2,3)
    println(arregloEstatico);
    //Dinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(
        1,2,3,4,5,6,7,8,9,10
    )
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // FOR EACH => Unit
    // Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach { valorActual: Int -> // - > = >
                println("Valor actual: $valorActual"); // Tanto valorActual como it pueden tener o no los corchetes
        }
    // it (en ingles "eso") significa el elemento iterado
    arregloDinamico.forEach{ println("Valor actual (it): $it")}

    // MAP -> MUTA(Modifica cambia) el arreglo
    // 1) Enviamos el nuevo valor de la iteracion
    // 2) Nos devuelve un NUEVO ARREGLO con valores
    //    de las iteraciones
    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100
        }
    println(respuestaMap)
    val respuestaMapDos = arregloDinamico.map { it + 15 }
    println(respuestaMapDos)

    //Filter -> Filtrar el arreglo
    // 1) Devolver una expresión (TRUE o FALSE)
    // 2) Nuevo arreglo filtrado
    val respuestaFilter: List<Int> = arregloDinamico
        .filter{ valorActual:Int ->
            //Expresión o condición
            val mayoresACinco: Boolean = valorActual > 5
            return@filter mayoresACinco
        }

    val respuestaFilterDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFilter)
    println(respuestaFilterDos)

    // OR AND
    // OR -> ANY (Alguno cumple?)
    // AND -> ALL (Todos cumplen?)
    val respuestaAny: Boolean = arregloDinamico
        .any { valorActual:Int ->
            return@any (valorActual > 5)
        }
    println(respuestaAny) //True
    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual:Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll) // False

    // REDUCE -> Valor acumulado
    // Valor acumulado = 0 (Siempre empieza en 0 en Kotlin)
    // [1,2,3,4,5] -> Acumular "SUMAR" estos valores del arreglo
    // ValorIteracion1 = valorEmpieza + 1 = 0 + 1 = 1 -> Iteracion 1
    // valorIteracion2 = valorAcumuladoIteracion1 + 2 = 1 + 2 = 3 -> Iteracion2
    // valorIteracion3 = valorAcumuladoIteracion2 + 3 = 3 + 3 = 6 -> Iteracion3
    // valorIteracion4 = valorAcumuladoIteracion3 + 4 = 6 + 4 = 10 -> Iteracion4
    // valorIteracion5 = valorAcumuladoIteracion4 + 5 = 10 + 5 = 15 -> Iteracion5
    val respuestaReduce: Int = arregloDinamico
        .reduce { acumulado:Int, valorActual:Int ->
            return@reduce (acumulado + valorActual) // -> Cambiar o usar la logica de negocio
        }
    println(respuestaReduce)
    // return@reduce acumulado + (itemCarrto.Cantidad * itemCarrito.precio)


}// Termina funcion main

//void -> Unit
fun imprimirNombre(nombre:String): Unit{
    println("Nombre: ${nombre}") //Template strings
}
fun calcularSueldo(
    sueldo:Double, //Requerido
    tasa:Double = 12.00, // Opcional (defecto)
    bonoEspecial: Double? = null // Opcional (nullable)
    // Variable? -> "?" es Nullable (osea que se puede en algun momento ser nulo)
):Double {
    // Int -> Int? (nullable)
    // String -> String? (nullable)
    // Date -> Date? (nullable)
    if(bonoEspecial == null){
        return sueldo * (100/tasa)
    }else{
        return sueldo * (100/tasa) * bonoEspecial
    }
}

abstract class NumerosJava{
    protected val numeroUno:Int
    private val numeroDos:Int
    constructor(
        uno:Int,
        dos:Int
    ){
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializando")
    }
}

abstract class Numeros( // Constructor pPrimario
    // Caso 1) Parametro normal
    // uno:Int , (parametro (sin modificador acceso))

    // Caso 2) Parametro y propiedad (atributo) (private)
    // private var uno:Int (propiedad "instancia.uno")

    // Caso 3) Parametro y propiedad publica (atributo)
    // var uno:Int (propiedad "instancia.uno") (public)
    protected val numeroUno:Int, // Instancia.numeroUno
    protected val numeroDos:Int, // Instancia.numeroDos
){
    init { //bloque constructor primario
        println("Inicializando")
    }
}

class Suma( //Constructor primario
    unoParametro: Int, //Parametro
    dosParametro: Int, //Parametros
): Numeros( //Clase papá, Numeros (extendiendo)
    unoParametro,
    dosParametro
){
    public val soyPublicoExplicito:String = "Explicito" //Publicas
    val soyPublicoImplicito:String = "Implicito" //Publicas
    init { //bloque codigo constructor primario
        this.numeroUno
        this.numeroDos
        numeroUno // this. OPCIONAL (propiedades, metodos)
        numeroDos // this. OPCIONAL (propiedades, metodos)
        this.soyPublicoExplicito
        soyPublicoImplicito // this. OPCIONAL (propiedades, metodos)
    }
    // public fun sumar():Int{  (Opcional "public")
    constructor( // Constructor secundario
        uno:Int?,
        dos:Int
    ):this(
        if(uno == null) 0 else uno,
        dos
    )
    constructor( // Constructor tercero
        uno:Int,
        dos:Int?
    ):this(
        uno,
        if(dos == null) 0 else dos,
    )

    constructor( // Constructor cuarto
        uno:Int?,
        dos:Int?
    ):this(
        if(uno == null) 0 else uno,
        if(dos == null) 0 else dos,
    )




    fun sumar():Int{
        val total = numeroUno + numeroDos
        //Suma.agregarHistorial(total) ("Suma." o "Nombre Clase." es opcional)
        agregarHistorial(total)
        return total
    }
    companion object{ // se comparte entre todas las instancias, similar al static
        // funciones y variables
        val pi = 3.14
        fun elevarAlCuadrado(num:Int):Int{
            return num * num
        }
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorTotalSumas:Int){
            historialSumas.add(valorTotalSumas)
        }
    }
}