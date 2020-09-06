package github.dandeduck.math.geometry;

public interface Ellipse {
    double semiMajorAxis();
    double semiMinorAxis();

    default double h() {
        double a = semiMajorAxis();
        double b = semiMinorAxis();

        return Math.pow(a-b, 2) / Math.pow(a+b, 2);
    }

    default double eccentricity() {
        double a = semiMajorAxis();
        double b = semiMinorAxis();

        return Math.sqrt(a*a - b*b) / a;
    }

    default double distanceFromCenterToFocalPoint() {
        return eccentricity() * semiMajorAxis();
    }
}
