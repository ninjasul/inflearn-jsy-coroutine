package section5

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime: Long = System.currentTimeMillis()

    val result = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] 결과값이 반환됩니다.")
        "결과값"
    }

    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] $result")
}


private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"