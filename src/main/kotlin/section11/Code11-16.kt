package section11

import kotlinx.coroutines.*

fun main(): Unit = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 작업 1")

    launch(Dispatchers.Unconfined) {
        println("[${Thread.currentThread().name}] 작업 2")
    }

    println("[${Thread.currentThread().name}] 작업 3")
}