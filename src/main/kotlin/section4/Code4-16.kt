package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val whileJob: Job = launch(Dispatchers.Default) {
        // this는 CoroutineScope 를 가리킴.
        while (this.isActive) {
            println("작업 중")
            // 일시 중단 없이 계속 실행 가능
        }
    }

    delay(100L)
    whileJob.cancel()
}