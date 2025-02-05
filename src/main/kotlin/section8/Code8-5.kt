package section8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    val result = searchByKeyword("Kotlin")

    result.forEach { println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] $it") }
}

private suspend fun searchByKeyword(keyword: String): Array<String> =
    supervisorScope {
        val dbResultsDeferred = async {
            throw Exception("DB 읽기 오류 발생")
            searchFromDB(keyword)
        }

        val serverResultsDeferred = async {
            searchFromServer(keyword)
        }

        val dbResults: Array<String> = try {
            dbResultsDeferred.await()
        } catch (e: Exception) {
            arrayOf() // 예외 발생 시 빈 결과
        }

        val serverResults: Array<String> = try {
            serverResultsDeferred.await()
        } catch (e: Exception) {
            arrayOf()
        }

        return@supervisorScope arrayOf(*dbResults, *serverResults)
    }

private suspend fun searchFromDB(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[DB]${keyword}1", "[DB]${keyword}2")
}

private suspend fun searchFromServer(keyword: String): Array<String> {
    delay(1000L)
    return arrayOf("[Server]${keyword}1", "[Server]${keyword}2")
}

private fun getElapsedTime(startTime: Long): String =
    "지난 시간: ${System.currentTimeMillis() - startTime}ms"