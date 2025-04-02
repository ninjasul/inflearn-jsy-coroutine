package section4

import kotlinx.coroutines.*

private val startTime: Long by lazy { System.currentTimeMillis() }

fun main() = runBlocking<Unit> {
    startTime

    val longJob: Job = launch(Dispatchers.Default) {
        // Thread.sleep(1000L) 대신 delay 사용 시에만 실시간 취소 가능
        delay(1000L)
        println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] longJob 코루틴의 동작")
    }

    longJob.cancelAndJoin()        // 취소 요청 + 코루틴 취소 완료 시점까지 대기
    executeAfterJobCancelled()    // 코루틴이 진짜로 취소된 뒤 실행
}

private fun executeAfterJobCancelled() {
    println("[${Thread.currentThread().name}][${getElapsedTime(startTime)}] longJob 코루틴 취소 후 실행돼야 하는 동작")
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}밀리초"