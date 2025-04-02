package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        // Coroutine1 의 Job
        val coroutine1Job = this.coroutineContext[Job]

        val newJob = Job(coroutine1Job)

        launch(CoroutineName("Coroutine2") + newJob) {
            delay(100L)
            println("[${Thread.currentThread().name}] 코루틴 실행")
        }
    }
}