package section6

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 코루틴 실행")

    // launch 는 비동기 호출
    launch {
        println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 코루틴 실행")
        delay(1000L)
        println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 코루틴 종료")
    }

    println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] 코루틴 종료")
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"

/**
[지난 시간: 0ms][main @coroutine#1] 코루틴 실행
[지난 시간: 10ms][main @coroutine#1] 코루틴 종료
[지난 시간: 12ms][main @coroutine#2] 코루틴 실행
[지난 시간: 1022ms][main @coroutine#2] 코루틴 종료
 */