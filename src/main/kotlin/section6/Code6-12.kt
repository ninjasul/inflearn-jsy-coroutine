package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // 새로운 루트 Job 생성
    val newRootJob: CompletableJob = Job()

    launch(CoroutineName("Coroutine1") + newRootJob) {
        launch(CoroutineName("Coroutine3")) {
            delay(100L)
            println("Coroutine3 실행")
        }

        launch(CoroutineName("Coroutine4")) {
            delay(100L)
            println("Coroutine4 실행")
        }
    }

    launch(CoroutineName("Coroutine2") + newRootJob) {
        launch(CoroutineName("Coroutine5")) {
            delay(100L)
            println("Coroutine5 실행")
        }
    }

    // newRootJob 취소 요청 -> 해당 Job의 자식 코루틴 전체 취소됨
    newRootJob.cancel()
    delay(1000L)
}