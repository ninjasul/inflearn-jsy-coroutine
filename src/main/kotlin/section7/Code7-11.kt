package section7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        // 1초간 지속
        delay(1000L)
    }

    job.invokeOnCompletion { exception ->
        // 발생한 예외 출력
        println(exception)
    }

    // job 취소
    job.cancel()
}