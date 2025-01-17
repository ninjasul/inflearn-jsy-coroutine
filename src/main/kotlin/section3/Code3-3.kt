package section3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit> {
    val imageProcessingDispatcher = Dispatchers.Default.limitedParallelism(2)
    repeat(100) {
        launch(imageProcessingDispatcher) {
            Thread.sleep(1000L) // 이미지 처리 작업 (블로킹 가정)
            println("[${Thread.currentThread().name}] 이미지 처리 완료")
        }
    }
}