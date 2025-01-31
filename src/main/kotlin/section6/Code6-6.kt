package section6

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    launch {
        delay(1000L)
        println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] launch 코루틴 종료")
    }

    delay(2000L)
    println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] runBlocking 코루틴 종료")
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"