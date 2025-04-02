package section11

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch(start = CoroutineStart.UNDISPATCHED) {
        println("작업 1")
    }

    job.cancel()
    println("작업 2")
}
