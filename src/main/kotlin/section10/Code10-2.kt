package section10

import kotlinx.coroutines.*

fun main(): Unit = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    val whileJob: Job = launch(Dispatchers.Default) {
        while (this.isActive) {
            println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 작업 중")
        }
    }

    delay(100L)
    whileJob.cancel()
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"