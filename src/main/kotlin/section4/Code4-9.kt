package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) { repeatTime ->
            delay(1000L) // 1000ms 대기
            println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 반복횟수 $repeatTime")
        }
    }
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"