package section6

import kotlinx.coroutines.*

fun main() = runBlocking(CoroutineName("RunBlockingCoroutine1")) {
    val startTime: Long = System.currentTimeMillis()

    runBlocking(CoroutineName("RunBlockingCoroutine2")) {
        delay(1000L)

        launch(CoroutineName("LaunchCoroutine1")) {
            delay(1000L)
            println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] launchCoroutine1 코루틴 종료")
        }

        println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] RunBlockingCoroutine2 코루틴 종료")
    }

    launch(CoroutineName("LaunchCoroutine2")) {
        delay(1000L)

        runBlocking(CoroutineName("RunBlockingCoroutine3")) {
            delay(1000L)

            launch(CoroutineName("LaunchCoroutine3")) {
                delay(1000L)
                println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] launchCoroutine3 코루틴 종료")
            }

            println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] RunBlockingCoroutine3 코루틴 종료")
        }

        println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] LaunchCoroutine2 코루틴 종료")
    }

    delay(2000L)
    println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] RunBlockingCoroutine1 코루틴 종료")
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"