package section11

import kotlinx.coroutines.*

private var count = 0
private val singleThreadContext = newSingleThreadContext("SingleThread")

fun main() = runBlocking {
    withContext(singleThreadContext) {
        repeat(10_000) {
            launch {
                count++
            }
        }
    }

    println("count = $count")
}