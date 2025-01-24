package section5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val result = async(Dispatchers.IO) {
        delay(1000L)            // 네트워크 요청 (예시)
        return@async "결과값"              // 결과값 반환
    }.await()                           // 코루틴이 완료될 때까지 대기

    println(result)                     // 결과값 출력
}