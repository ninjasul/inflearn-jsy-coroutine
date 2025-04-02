package section4

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val convertImageJob1 = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지1 변환 완료")
    }

    val convertImageJob2 = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지2 변환 완료")
    }

    // 두 코루틴이 모두 끝날 때까지 대기
    joinAll(convertImageJob1, convertImageJob2)

    val uploadImageJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 이미지1,2 업로드")
    }
}