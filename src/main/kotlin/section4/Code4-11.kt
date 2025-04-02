package section4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private val startTime: Long by lazy { System.currentTimeMillis() }

fun main() = runBlocking<Unit> {
    startTime

    val longJob: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L) // 스레드 직접 블로킹
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] longJob 코루틴의 동작")
    }

    longJob.cancel()              // 취소 요청
    executeAfterJobCancelled()    // 여기서 longJob이 취소된 후에 실행돼야 하는 동작
}

private fun executeAfterJobCancelled() {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] longJob 코루틴 취소 후 실행돼야 하는 동작")
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"