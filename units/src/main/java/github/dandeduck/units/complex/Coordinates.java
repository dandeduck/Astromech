package github.dandeduck.units.complex;

import github.dandeduck.units.distance.Distance;

public class Coordinates {
    private final Distance x;
    private final Distance y;

    public Coordinates() {
        this(Distance.meters(0), Distance.meters(0));
    }

    public Coordinates(Distance x, Distance y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates shiftXY(Distance distance) {
        return new Coordinates(x.add(distance), y.add(distance));
    }

    public Coordinates shiftX(Distance addition) {
        return new Coordinates(x.add(addition), y);
    }

    public Coordinates shiftY(Distance addition) {
        return new Coordinates(x, y.add(addition));
    }

    public Distance x() {
        return x;
    }

    public Distance y() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("X: %s, Y: %s",x,y);
    }
}
