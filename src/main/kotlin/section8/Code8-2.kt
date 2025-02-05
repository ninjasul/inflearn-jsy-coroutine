package section8

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    delayAndPrintHelloWorld()
    delayAndPrintHelloWorld()
}

private suspend fun delayAndPrintHelloWorld() {
    delay(1000L)
    println("Hello World")
}