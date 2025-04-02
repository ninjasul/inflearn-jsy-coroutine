package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        while (true) {
            println("작업 중")
            yield()  // 스레드 양보 -> 일시 중단 -> 취소 여부 확인 후 즉시 재개 요청
        }
    }

    delay(100L)
    whileJob.cancel()
}