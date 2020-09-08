package github.dandeduck.math.geometry;

public interface Circle extends Ellipse{
    @Override
    default double semiMajorAxis() {
        return semiMinorAxis();
    };

    @Override
    default double semiMinorAxis() {
        return radius();
    }

    double radius();
}
