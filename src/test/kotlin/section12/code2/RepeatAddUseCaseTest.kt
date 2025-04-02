package section12.code2

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class RepeatAddUseCaseTest {
    @Test
    fun `100번 더하면 100이 반환된다`() = runBlocking {
        // Given
        val repeatAddUseCase = RepeatAddUseCase()

        // When
        // 오류: Suspend function 'add' should be called only from a coroutine or another suspend function
        val result: Int = repeatAddUseCase.add(100)

        // Then
        assertEquals(100, result)
    }
}