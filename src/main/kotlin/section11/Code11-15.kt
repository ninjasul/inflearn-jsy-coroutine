package section11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking<Unit>(Dispatchers.IO) {
    println("runBlocking 코루틴 실행 스레드: ${Thread.currentThread().name}")

    launch {
        println("launch 코루틴 실행 스레드: ${Thread.currentThread().name}")
    }
}