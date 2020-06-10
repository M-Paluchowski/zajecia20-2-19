package example.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator systemUnderTest;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before each test");
        systemUnderTest = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each test");
    }

    @Test
    void nazwaMetodyTestowej() {
        // logika testu
    }

    @Test
    //shouldReturnFiveWhenDividingTenByTwo
    void whenDividingTenByTwo_shouldReturnFive() {
        //given
        int preparedFirstNumber = 10;
        int preparedSecondNumber = 2;

        //when
        int result = systemUnderTest.divide(preparedFirstNumber, preparedSecondNumber);

        //then
        int expectedResult = 5;
        assertEquals(expectedResult, result);

        assertThat(result)
            .isEqualTo(expectedResult);
    }

    @Test
    void whenDividingByZero_shouldThrowException() {
        //given
        int preparedFirstNumber = 10;
        int preparedSecondNumber = 0;

        //when
        Executable methodCall = () -> systemUnderTest.divide(preparedFirstNumber, preparedSecondNumber);
        Throwable throwable = catchThrowable(() -> systemUnderTest.divide(preparedFirstNumber, preparedSecondNumber));

        //then
        assertThrows(ArithmeticException.class, methodCall);
        assertThat(throwable)
                .isInstanceOf(ArithmeticException.class);
    }

    @Test
    void test() {
        assertThat(List.of(1,2,3,4))
                .describedAs("asdf")
                .contains(4, 5)
                .doesNotContain(2);
    }
}