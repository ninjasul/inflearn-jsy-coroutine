package section7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("[예외 로깅] $throwable")
    }

    CoroutineScope(Dispatchers.IO)
        .launch(CoroutineName("Coroutine1") + exceptionHandler) {
            launch(CoroutineName("Coroutine2")) {
                throw Exception("Coroutine2에 예외가 발생했습니다")
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }

            launch(CoroutineName("Coroutine3")) {
                delay(100L)
                println("[${Thread.currentThread().name}] 코루틴 실행")
            }
        }

    delay(1000L)
}