package sec;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class SubtractorTest {

    private static ISubtractor subtractor;

    @BeforeAll
    public static void setUp() {
        IAdder adder = Mockito.mock(IAdder.class);
        IFlipper flipper = Mockito.mock(IFlipper.class);


        Mockito.when(flipper.flip(5)).thenReturn(-5);
        Mockito.when(adder.add(3, -5)).thenReturn(-2);

        subtractor = new Subtractor(adder, flipper);

    }

    @Test
    public void subtractTest() {
        Assertions.assertEquals(-2, subtractor.subtract(3, 5));
    }

    @Test
    public void subtractTestMockito() {
        ISubtractor subtractors = Mockito.mock(ISubtractor.class);
        Mockito.when(subtractors.subtract(3,-6)).thenReturn(-3);
        Assertions.assertEquals(-3, subtractors.subtract(3, -6));
    }

}