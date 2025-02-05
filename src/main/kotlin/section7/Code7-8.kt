package section7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    supervisorScope {
        launch(CoroutineName("Coroutine1")) {
            launch(CoroutineName("Coroutine3")) {
                throw Exception("예외 발생")
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }

            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }

        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }

    delay(1000L)
}
