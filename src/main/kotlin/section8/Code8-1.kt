package section8

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking<Unit> {
    delay(1000L)
    println("Hello World")
    delay(1000L)
    println("Hello World")
}