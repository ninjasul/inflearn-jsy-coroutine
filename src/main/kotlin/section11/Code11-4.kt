package section11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

private var count = 0
private val mutex = Mutex()

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                mutex.withLock {
                    count++
                }
            }
        }
    }
    println("count = $count")
}