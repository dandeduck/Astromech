package github.dandeduck.math;

import org.apache.commons.math3.special.Gamma;

public class GeneralMath {
    public static double binomialCoefficient(double x, double y) {
        double res = Gamma.gamma(x + 1) / (Gamma.gamma(y + 1) * Gamma.gamma(x - y + 1));

        return Double.isNaN(res) ? 0 : res;
    }
}
