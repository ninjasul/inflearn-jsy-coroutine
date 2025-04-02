package section5

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val networkDeferred: Deferred<String> = async(Dispatchers.IO) {
        delay(1000L)
        return@async "Dummy Response"
    }

    // Deferred도 Job과 동일하게 join 사용 가능
    networkDeferred.join()

    // Job 상태값 출력 예시
    printJobState(networkDeferred)
}

private fun printJobState(job: Job) {
    println(
        "Job State\n" +
                "isActive >> ${job.isActive}\n" +
                "isCancelled >> ${job.isCancelled}\n" +
                "isCompleted >> ${job.isCompleted} "
    )
}