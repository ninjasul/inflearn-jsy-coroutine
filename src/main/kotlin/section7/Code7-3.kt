package section7

import kotlinx.coroutines.Job
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay

fun main() = runBlocking<Unit> {
    val parentJob = launch(CoroutineName("Parent Coroutine")) {

        // 새로운 Job 객체를 만들어 Coroutine1에 연결
        launch(CoroutineName("Coroutine1") + Job()) {
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

    delay(20L)

    // Parent Coroutine에 취소 요청
    parentJob.cancel()

    delay(1000L)
}