package section5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // 1. 시작 시간 기록
    val startTime: Long = System.currentTimeMillis()

    // 2. 플랫폼1에서 등록한 관람객 목록을 가져오는 코루틴 실행
    val participantDeferred1: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(timeMillis = 1000L)
        return@async arrayOf("철수", "영수")
    }

    // 3. 플랫폼2에서 등록한 관람객 목록을 가져오는 코루틴 실행
    val participantDeferred2: Deferred<Array<String>> = async(Dispatchers.IO) {
        delay(timeMillis = 1000L)
        return@async arrayOf("영희")
    }

    // 4. 결과가 수신될 때까지 대기
    val participants1: Array<String> = participantDeferred1.await()
    val participants2: Array<String> = participantDeferred2.await()

    // 5. 지난 시간 표시 및 참여자 목록을 병합해 출력
    println("[${getElapsedTime(startTime)}] 참여자 목록: ${listOf(*participants1, *participants2)}")
}

private fun getElapsedTime(startTime: Long): String = "지난 시간: ${System.currentTimeMillis() - startTime}ms"