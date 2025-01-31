package section7

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    // supervisorJob 의 부모로 runBlocking으로 생성된 Job 객체 설정
    val supervisorJob = SupervisorJob(this.coroutineContext[Job])

    launch(CoroutineName("Coroutine1") + supervisorJob) {
        launch(CoroutineName("Coroutine3")) {
            throw Exception("예외 발생")
        }

        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }

    launch(CoroutineName("Coroutine2")) {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행")
    }

    supervisorJob.complete()
}