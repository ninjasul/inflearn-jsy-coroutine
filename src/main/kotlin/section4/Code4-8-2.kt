package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val lazyJob: Job = launch(start = CoroutineStart.LAZY) {
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] launch 코루틴 지연 실행")
    }

    delay(3000L)     // 3000밀리초 동안 runBlocking 코루틴 일시 중단
    lazyJob.join()            // 여기서 지연 코루틴 실행 요청
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"