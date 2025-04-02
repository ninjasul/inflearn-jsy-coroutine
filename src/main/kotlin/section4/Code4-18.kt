package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job: Job = launch {
        delay(1000L)
    }

    println(job)
}