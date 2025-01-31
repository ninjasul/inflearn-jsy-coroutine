package section7

import kotlinx.coroutines.Job
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Parent Coroutine")) {

        // 새로운 Job 객체를 만들어 Coroutine1에 연결
        launch(CoroutineName("Coroutine1") + Job()) {
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