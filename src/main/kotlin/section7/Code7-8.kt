package section7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    supervisorScope {
        launch(CoroutineName("Coroutine1")) {
            launch(CoroutineName("Coroutine3")) {
                throw Exception("예외 발생")
            }

            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine1 실행함")
        }

        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine2 실행함")
        }
    }

    delay(1000L)
}
