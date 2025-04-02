package section11

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        println("작업 1")
    }

    job.cancel() // 생성 상태에서 취소
    println("작업 2")
}
