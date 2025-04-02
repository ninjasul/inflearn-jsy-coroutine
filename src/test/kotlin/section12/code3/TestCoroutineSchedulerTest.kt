package section12.code3

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class TestCoroutineSchedulerTest {

    @Test
    fun `가상 시간 조절 테스트`() {
        val testCoroutineScheduler = TestCoroutineScheduler()

        // 5초 흐르게
        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(5000L, testCoroutineScheduler.currentTime)

        // 6초 흐르게
        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(11000L, testCoroutineScheduler.currentTime)

        // 10초 흐르게
        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(21000L, testCoroutineScheduler.currentTime)
    }

    @Test
    fun `가상 시간 위에서 테스트 진행`() {
        // Given
        val testCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        val testCoroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        // When
        testCoroutineScope.launch {
            delay(10_000L) // 10초 대기
            result = 1
            delay(10_000L) // 10초 대기
            result = 2
        }

        // Then
        // 5초 흐르게 - 아직 result = 0
        testCoroutineScheduler.advanceTimeBy(5000L)
        assertEquals(0, result)

        // 6초 흐르게 - 총 11초가 되어 result = 1
        testCoroutineScheduler.advanceTimeBy(6000L)
        assertEquals(1, result)

        // 10초 더 흐르게 - 총 21초가 되어 result = 2
        testCoroutineScheduler.advanceTimeBy(10000L)
        assertEquals(2, result)
    }

    @Test
    fun `advanceUtilIdle 동작 살펴보기`() {
        // Given
        val testCoroutineScheduler = TestCoroutineScheduler()
        val testDispatcher = StandardTestDispatcher(scheduler = testCoroutineScheduler)
        val testCoroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        // When
        testCoroutineScope.launch {
            delay(10_000L) // 10초 대기
            result = 1
            delay(10_000L) // 10초 대기
            result = 2
        }

        // testCoroutineScope 하위의 코루틴들을 모두 실행 시키고 완료될 때까지 대기
        testCoroutineScheduler.advanceUntilIdle()

        assertEquals(2, result)
    }

    @Test
    fun `StandardTestDispatcher 사용하기`() {
        // Given
        val testDispatcher = StandardTestDispatcher()
        val testCoroutineScope = CoroutineScope(context = testDispatcher)

        var result = 0

        // When
        testCoroutineScope.launch {
            delay(10_000L) // 10초 대기
            result = 1
            delay(10_000L) // 10초 대기
            result = 2
        }

        testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(2, result)
    }

    @Test
    fun `TestScope 사용하기`() {
        // Given
        val testCoroutineScope: TestScope = TestScope()
        var result = 0

        // When
        testCoroutineScope.launch {
            delay(10_000L)
            result = 1
            delay(10_000L)
            result = 2
        }

        testCoroutineScope.advanceUntilIdle() // 모든 코루틴 완료까지 가상시간 흐르게 함

        // Then
        assertEquals(2, result)
    }
}