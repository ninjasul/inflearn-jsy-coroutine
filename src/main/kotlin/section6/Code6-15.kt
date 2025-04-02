package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("Coroutine1")) {
        val coroutine1Job = this.coroutineContext[Job]
        val newJob = Job(coroutine1Job)

        launch(CoroutineName("Coroutine2") + newJob) {
            delay(100L)

            println("[${Thread.currentThread().name}] 코루틴 실행")
            println("[${Thread.currentThread().name}] ${this.coroutineContext[Job]}")
        }

        println("[${Thread.currentThread().name}] ${this.coroutineContext[Job]}")
    }

    println("[${Thread.currentThread().name}] ${this.coroutineContext[Job]}")
}