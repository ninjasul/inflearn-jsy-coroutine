package section11

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    launch(Dispatchers.Unconfined) {
        println("[Dispatchers.Unconfined] 시작 스레드: ${Thread.currentThread().name}")
        delay(100)
        println("[Dispatchers.Unconfined] 재개 스레드: ${Thread.currentThread().name}")
    }
}