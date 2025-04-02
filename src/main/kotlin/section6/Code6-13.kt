package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // 새로운 루트 Job 생성
    val newRootJob: CompletableJob = Job()

    launch(CoroutineName("Coroutine1") + newRootJob) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine3 실행")
        }

        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine4 실행")
        }
    }

    launch(CoroutineName("Coroutine2") + newRootJob) {
        launch(CoroutineName("Coroutine5") + Job()) {
            delay(100L)
            println("[${Thread.currentThread().name}] Coroutine5 실행")
        }
    }

    // 모든 코루틴이 생성될 때 까지 대기
    delay(50L)

    newRootJob.cancel()
    delay(1000L)
}