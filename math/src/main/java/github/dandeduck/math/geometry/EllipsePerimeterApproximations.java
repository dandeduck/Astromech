package github.dandeduck.math.geometry;

//note to self, they are the methods are ordered by how good of an approximation they are giving. From the worst, to the best. thx Ramanujan XOXOXO
public class EllipsePerimeterApproximations {
    public static double geometricMean(Ellipse ellipse) {
        return 2 * Math.PI * Math.sqrt(ellipse.semiMajorAxis() * ellipse.semiMinorAxis());
    }

    public static double mathematicalMean(Ellipse ellipse) {
        return Math.PI * (ellipse.semiMajorAxis() + ellipse.semiMinorAxis());
    }

    public static double rootMeanSquare(Ellipse ellipse) {
        double a = ellipse.semiMajorAxis();
        double b = ellipse.semiMinorAxis();

        return 2 * Math.PI * Math.sqrt((a*a + b*b)/2);
    }

    public static double firstRamanujan(Ellipse ellipse) {
        double a = ellipse.semiMajorAxis();
        double b = ellipse.semiMinorAxis();

        return Math.PI * (3*(a+b) - Math.sqrt((3*a + b) * (a + 3*b)));
    }

    public static double secondRamanujan(Ellipse ellipse) {
        double threeH = 3 * ellipse.h();

        return Math.PI * (ellipse.semiMajorAxis() + ellipse.semiMinorAxis()) * (1 + (threeH) / (10 + Math.sqrt(4 - threeH)));
    }
}
