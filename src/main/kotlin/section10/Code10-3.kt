package section10

import kotlinx.coroutines.*

fun main(): Unit = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    val dispatcher: ExecutorCoroutineDispatcher = newFixedThreadPoolContext(nThreads = 2, name = "Thread")

    launch(dispatcher) {
        repeat(5) { i ->
            println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] ${i + 1}번째 코루틴 실행이 일시 중단 됩니다")
            delay(100L)
            println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] ${i + 1}번째 코루틴 실행이 재개 됩니다")
        }
    }
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"