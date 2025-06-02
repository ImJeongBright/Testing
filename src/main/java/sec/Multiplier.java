package sec;

public class Multiplier implements IMultiplier{
    public Multiplier(IAdder adder, IFlipper flipper) {
    }

    @Override
    public int multiply(int number1, int number2) {
        return number1 * number2;
    }
}
