package section6

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    // 부모 코루틴 실행
    val parentJob = launch {
        // 자식 코루틴 실행
        launch {
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 자식 코루틴 실행 완료")
        }

        println("[${getElapsedTime(startTime)}] 부모 코루틴이 실행하는 마지막 코드")
    }

    // 부모 코루틴 실행 완료되거나 취소 완료되어 완료될 때 호출될 콜백 등록
    parentJob.invokeOnCompletion {
        println("[${getElapsedTime(startTime)}] 부모 코루틴 실행 완료")
    }

    // 500ms 지연 후 부모 코루틴 상태 출력
    delay(500L)
    println(parentJob)
    printJobState(parentJob)
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"

private fun printJobState(job: Job) {
    println(
        "Job State\n" +
                "isActive >> ${job.isActive}\n" +
                "isCancelled >> ${job.isCancelled}\n" +
                "isCompleted >> ${job.isCompleted}"
    )
}