package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    this.coroutineContext
    // 새로운 루트 Job 생성
    val newScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    newScope.launch(CoroutineName("Coroutine1")) {
  
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine3 실행")
        }

        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine4 실행")
        }
    }

    newScope.launch(CoroutineName("Coroutine2")) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine5 실행")
        }
    }

    delay(1000L)
}