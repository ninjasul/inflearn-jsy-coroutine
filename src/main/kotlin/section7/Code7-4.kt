package section7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // SupervisorJob 객체를 만들어 Coroutine1에 연결
    val supervisorJob = SupervisorJob()

    launch(CoroutineName("Coroutine1") + supervisorJob) {
        launch(CoroutineName("Coroutine3")) {
            throw Exception("예외 발생")
        }

        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }

    delay(1000L)
}