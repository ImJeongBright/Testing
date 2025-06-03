package sec;

public class Subtractor implements ISubtractor{
    private final IAdder iAdder;
    private final IFlipper iFlipper;

    public Subtractor(IAdder iAdder, IFlipper iFlipper) {
        this.iAdder = iAdder;
        this.iFlipper = iFlipper;
    }

    @Override
    public int subtract(int a, int b) {
        return iAdder.add(a, iFlipper.flip(b));
    }

}
