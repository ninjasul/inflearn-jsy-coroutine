package section3

import kotlin.reflect.KFunction2


fun add(a: Int,b:Int): Int= a+b
fun sub(a: Int,b:Int): Int= a-b

fun main() {
    println(calculate(3,3,::add)) //6
    println(calculate(3,3,::sub)) //0

    println(calculate2(3,3,::add)) //6
    println(calculate2(3,3,::sub)) //0

}

fun calculate2(a: Int, b: Int, operation: KFunction2<Int, Int, Int>): Int {
    return operation(a, b)
}

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}
