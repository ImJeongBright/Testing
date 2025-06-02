package sec;

public class Flipper implements IFlipper{
    @Override
    public int flip(int number) {
        return number < 0 ? number * -1 : number;
    }
}
