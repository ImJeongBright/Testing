package sec;

public class Divider implements IDivider{


    @Override
    public int divide(int number1, int number2) {
        int result = 0;
        try {
            result = number1 / number2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return result;
    }
}
