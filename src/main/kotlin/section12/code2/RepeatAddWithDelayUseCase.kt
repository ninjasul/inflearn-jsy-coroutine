package section12.code2

import kotlinx.coroutines.*

class RepeatAddWithDelayUseCase {
    suspend fun add(repeatTime: Int): Int = withContext(Dispatchers.Default) {
        var result = 0

        repeat(repeatTime) {
            delay(100L)
            result += 1
        }

        return@withContext result
    }
}