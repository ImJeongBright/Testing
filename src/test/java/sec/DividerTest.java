package sec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {

    public static IDivider divider;

    @BeforeEach
    public void setUp() {
        IAdder adder = Mockito.mock(IAdder.class);
        IFlipper flipper = Mockito.mock(IFlipper.class);
        Mockito.when(flipper.flip(-2)).thenReturn(2);
        Mockito.when(flipper.flip(3)).thenReturn(-3);
        Mockito.when(adder.add(0, 3)). thenReturn(3);
        Mockito.when(adder.add(3, 3)). thenReturn(6);
        Mockito.when(adder.add(0, -3)). thenReturn(-3);
        Mockito.when(adder.add(-3, -3)).thenReturn(-6);
        divider = new Divider();
    }

    @Test
    @DisplayName("정상적인 수를 나눈다.")
    void divideInteger() {
        Assertions.assertEquals(6, divider.divide(12, 2));
    }


    @Test
    @DisplayName("0을 나눴을 시 에러 던지기")
    void divideZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> divider.divide(6, 0));
    }

}