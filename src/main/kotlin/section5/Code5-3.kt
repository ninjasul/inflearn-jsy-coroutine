package section5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val result = withContext(Dispatchers.IO) {
        delay(1000L)
        "결과값"
    }

    println(result)
}