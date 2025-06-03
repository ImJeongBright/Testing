package sec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MultiplierTest {

    private static IMultiplier multiplier;

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
        multiplier = new Multiplier(adder, flipper);
    }

    @Test
    @DisplayName("Assertions를 이용한 multiply (Positive)")
    public void multiplyTest1() {
        Assertions.assertEquals(6, multiplier.multiply(3, 2));
    }

    @Test
    @DisplayName("Assertions를 이용한 multiply (Negative)")
    public void multiplyTest2() {
        Assertions.assertEquals(-6, multiplier.multiply(3, -2));
    }

    @Test
    @DisplayName("0 곱하기")
    public void multiplyZero() {
        Assertions.assertEquals(0, multiplier.multiply(3, 0));
    }

    @Test
    @DisplayName("Mockito를 이용한 multiply (Positive)")
    public void multiplyTestWithMockito() {
        IMultiplier multiplier2 = Mockito.mock(IMultiplier.class);

        Mockito.when(multiplier2.multiply(12, -2)).thenReturn(-24);

        Assertions.assertEquals(-24, multiplier2.multiply(12, -2));
    }


}

