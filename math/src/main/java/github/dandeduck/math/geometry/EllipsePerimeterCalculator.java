package github.dandeduck.math.geometry;

import github.dandeduck.math.GeneralMath;

//note to self, they are the methods are ordered by how good of an approximation they are giving. From the worst, to the best. thx Ramanujan XOXOXO
public class EllipsePerimeterCalculator {
    public static double geometricMeanApproximation(Ellipse ellipse) {
        return 2 * Math.PI * Math.sqrt(ellipse.semiMajorAxis() * ellipse.semiMinorAxis());
    }

    public static double mathematicalMeanApproximation(Ellipse ellipse) {
        return Math.PI * (ellipse.semiMajorAxis() + ellipse.semiMinorAxis());
    }

    public static double rootMeanSquareApproximation(Ellipse ellipse) {
        double a = ellipse.semiMajorAxis();
        double b = ellipse.semiMinorAxis();

        return 2 * Math.PI * Math.sqrt((a*a + b*b)/2);
    }

    public static double firstRamanujanApproximation(Ellipse ellipse) {
        double a = ellipse.semiMajorAxis();
        double b = ellipse.semiMinorAxis();

        return Math.PI * (3*(a+b) - Math.sqrt((3*a + b) * (a + 3*b)));
    }

    public static double secondRamanujanApproximation(Ellipse ellipse) {
        double threeH = 3 * ellipse.h();

        return Math.PI * (ellipse.semiMajorAxis() + ellipse.semiMinorAxis()) * (1 + (threeH) / (10 + Math.sqrt(4 - threeH)));
    }

    public static double calculateViaSeries(Ellipse ellipse, int maxHPower) {
        double firstPart = Math.PI * ellipse.semiMajorAxis() * ellipse.semiMinorAxis();
        double h =  ellipse.h();
        double seriesSum = 0;

        for (int i = 0; i <= maxHPower; ++i)
            seriesSum += Math.pow(GeneralMath.binomialCoefficient(0.5, i), 2) * Math.pow(h, i);

        return firstPart * seriesSum;
    }
}
