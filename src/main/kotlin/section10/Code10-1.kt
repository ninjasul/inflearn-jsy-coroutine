package section10

import kotlinx.coroutines.*

fun main(): Unit = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    launch {
        while(true) {
            println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 자식 코루틴에서 작업 실행 중")
            // 스레드 사용 권한 양보
            yield()
        }
    }

    while(true) {
        println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 부모 코루틴에서 작업 실행 중")
        // 스레드 사용 권한 양보
        yield()
    }
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"