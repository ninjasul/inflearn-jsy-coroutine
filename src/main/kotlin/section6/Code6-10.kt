package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행 완료")
        }
        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행 완료")
        }
        // Coroutine1의 CoroutineScope 취소 요청
        this.cancel()
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
}