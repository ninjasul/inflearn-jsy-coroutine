package section11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@Volatile
private var count = 0

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                count++
            }
        }
    }
    println("count = $count")
}