package sec;

public class Flipper implements IFlipper{
    @Override
    public int flip(int number) {
        return number * -1;
    }
}
