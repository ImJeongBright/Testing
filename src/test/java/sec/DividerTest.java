package sec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {

    @Mock
    public IDivider divider;

    @BeforeEach
    public void setUp() {
        ISubtractor subtractor = Mockito.mock(ISubtractor.class);
        IMultiplier multiplier = Mockito.mock(IMultiplier.class);

        Mockito.when(multiplier.multiply(2, 1)).thenReturn(2);
        Mockito.when(multiplier.multiply(2, 2)).thenReturn(4);
        Mockito.when(multiplier.multiply(2, 3)).thenReturn(6);
        Mockito.when(multiplier.multiply(2, 4)).thenReturn(8);
        Mockito.when(multiplier.multiply(2, 5)).thenReturn(10);
        Mockito.when(multiplier.multiply(2, 6)).thenReturn(12);

        Mockito.when(multiplier.multiply(3, 1)).thenReturn(3);
        Mockito.when(multiplier.multiply(3, 2)).thenReturn(6);
        Mockito.when(multiplier.multiply(3, 1)).thenReturn(3);
        Mockito.when(multiplier.multiply(3, 2)).thenReturn(6);

        Mockito.when(multiplier.multiply(2, -1)).thenReturn(-2);

        Mockito.when(multiplier.multiply(7, -1)).thenReturn(-7);
        Mockito.when(multiplier.multiply(3, -1)).thenReturn(-3);

        Mockito.when(subtractor.subtract(12, 12)).thenReturn(0);
        Mockito.when(subtractor.subtract(6, 6)).thenReturn(0);

        divider = new Divider(multiplier, subtractor);
    }

    @Test
    @DisplayName("정상적인 수를 나눈다.")
    void divideInteger() {
        Assertions.assertEquals(6, divider.divide(12, 2));
    }

    @Test
    @DisplayName("정상적인 수를 나눈다.")
    void divideIntegerWithMockito() {
        IDivider divider1 = Mockito.mock(IDivider.class);
        Mockito.when(divider1.divide(5, 2)).thenReturn(2);
        Assertions.assertEquals(2, divider1.divide(5, 2));
    }


    @Test
    @DisplayName("정상적인 수를 나눈다 / 양쪽 다 음수. (Negative)")
    void divideIntegerWithNegative() {
        Assertions.assertEquals(2, divider.divide(-6, -3));
    }

    @Test
    @DisplayName("정상적인 수를 나눈다 / 한 쪽만 음수. (Negative)")
    void divideIntegerWithNegative2() {
        Assertions.assertEquals(-2, divider.divide(6, -3));
    }

    @Test
    @DisplayName("0으로 나눴을 시 에러 던지기")
    void divideZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> divider.divide(6, 0));
    }

}