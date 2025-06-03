package sec;

public class Divider implements IDivider {

    private final IMultiplier multiplier;
    private final ISubtractor subtractor;

    public Divider(IMultiplier multiplier, ISubtractor subtractor) {
        this.multiplier = multiplier;
        this.subtractor = subtractor;
    }


    @Override
    public int divide(int dividend, int divisor) {

        zeroDivideException(divisor);

        int k = 1;
        int temp = 1;

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while (dividend > temp) {
            temp = multiplier.multiply(divisor, k++);
        }

        int remainder = subtractor.subtract(dividend, temp);
        return isNegative ? multiplier.multiply(k - 1, -1) : k - 1;
    }

    private static void zeroDivideException(int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

}
