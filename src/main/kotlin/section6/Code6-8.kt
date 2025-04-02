package section6

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val parentJob: Job = launch(Dispatchers.IO) { // 부모 코루틴 생성
        val dbResultsDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3").map {
            // 자식 코루틴 생성
            async {
                delay(1000L)
                println("${it}로부터 데이터를 가져오는데 성공했습니다")
                return@async "[${it}]data"
            }
        }

        // 모든 자식 코루틴 완료 대기 후 결과 반환
        val dbResults: List<String> = dbResultsDeferred.awaitAll()

        println(dbResults)
    }
}