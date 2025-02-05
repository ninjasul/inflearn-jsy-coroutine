package section8

import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val startTime: Long = System.currentTimeMillis()

    val result = searchByKeyword("Kotlin")

    result.forEach { println("[${getElapsedTime(startTime)}][${Thread.currentThread().name}] $it") }
}

private suspend fun searchByKeyword(keyword: String): Array<String> = coroutineScope {
    val dbResultsDeferred = async {
        searchFromDB(keyword)
    }

    val serverResultsDeferred = async {
        searchFromServer(keyword)
    }

    return@coroutineScope arrayOf(*dbResultsDeferred.await(), *serverResultsDeferred.await())
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