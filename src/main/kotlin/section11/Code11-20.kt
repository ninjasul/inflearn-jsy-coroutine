package section11

import kotlinx.coroutines.*
import kotlin.coroutines.resume


fun main() {
    runBlocking {
        val result: Response = executeNetworkCall()
        println(result)  // 코루틴 재개 시 반환 받은 결과 출력
    }
}

// 네트워크 콜을 코루틴에서 suspend 함수로 감싸는 예시
suspend fun executeNetworkCall(): Response {
    return suspendCancellableCoroutine { continuation ->
        // 실제 비동기 네트워크 함수 호출
        executeNetworkCallAsync(
            onSuccess = { resultString ->
                continuation.resume(Response.Success(resultString))
            },

            onFail = { throwable ->
                continuation.resume(Response.Fail(throwable))
            }
        )
    }
}

// 요청 결과를 나타내는 sealed class
sealed class Response {
    data class Success(val string: String) : Response()
    data class Fail(val throwable: Throwable) : Response()
}

// 가짜 비동기 네트워크 함수
fun executeNetworkCallAsync(
    onSuccess: (String) -> Unit,
    onFail: (Throwable) -> Unit
) {
    // 네트워크 요청 로직 처리 등
    // 여기서는 성공 콜백만 호출하도록 예시
    onSuccess("네트워크 요청 성공")
    // 에러 예시가 필요하다면 onFail(Throwable("에러")) 형태로 호출
}