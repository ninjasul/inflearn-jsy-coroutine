package section11

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch(start = CoroutineStart.DEFAULT) {
        println("작업 1")
    }

    println("작업 2")
}