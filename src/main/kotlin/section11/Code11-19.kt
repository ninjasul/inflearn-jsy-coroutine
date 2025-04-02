package section11

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    launch(start = CoroutineStart.UNDISPATCHED) {
        println("[Dispatchers.UNDISPATCHED] 시작 스레드: ${Thread.currentThread().name}")
        delay(100)
        println("[Dispatchers.UNDISPATCHED] 재개 스레드: ${Thread.currentThread().name}")
    }
}