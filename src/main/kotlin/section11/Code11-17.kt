package section11

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("[${Thread.currentThread().name}] 작업 1")

    launch {
        println("[${Thread.currentThread().name}] 작업 2")
    }

    println("[${Thread.currentThread().name}] 작업 3")
}