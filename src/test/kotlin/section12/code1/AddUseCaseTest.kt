package section12.code1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AddUseCaseTest {

    @Test
    fun `1,2,3을 더하면 6이다`() {
        val addUseCase: AddUseCase = AddUseCase()
        val result: Int = addUseCase.add(1, 2, 3)

        assertEquals(6, result)
    }
}