package section11

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import java.util.concurrent.locks.ReentrantLock

private var count = 0
private val reentrantLock = ReentrantLock()

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        repeat(10_000) {
            launch {
                reentrantLock.lock()
                count += 1
                reentrantLock.unlock()
            }
        }
    }
    println("count = $count")
}