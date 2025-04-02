package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
            delay(1L) // 1ms 동안 일시 중단 -> 취소 여부 확인 가능
        }
    }

    delay(100L)
    whileJob.cancel()
}