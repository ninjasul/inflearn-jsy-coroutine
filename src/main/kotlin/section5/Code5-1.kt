package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking<Unit> {
    val result = withContext(Dispatchers.IO) {
        delay(1000L)
        println("[${Thread.currentThread().name}] 결과값이 반환됩니다.")
        "결과값"
    }

    println("[${Thread.currentThread().name}] $result")
}