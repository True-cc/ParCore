package uwu.smsgamer.parcore.utils;

import java.util.Collection;

public class MathUtils {
    /**
     * Gets the variance I guess.
     * If p is greater than m, return 1.
     * If not, if the diff between them is
     * less than v, return diff / v.
     *
     * @param p Position
     * @param m Maximum
     * @param r Reverse
     * @param v Variance
     * @return Return value is *= -1 if r is true.
     * If p is greater than m, return 1.
     * If not, if the diff between them is
     * less than v, return diff / v.
     */
    public static double getVariance(double p, double m, boolean r, double v) {
        if (r ? p <= m : p >= m) return 1;
        double d = Math.abs(p - m);
        return d > v ? 0 : d / v;
    }

    public static double getVariance(double p, double max, double min, boolean r, double v) {
        double m = getVariance(p, max, !r, v);
        return m == 0 ? -getVariance(p, min, r, v) : m;
    }

    public static boolean approxEquals(double a, double b, double eps) {
        return Math.abs(a - b) < eps;
    }

    public static double getRating(Collection<Boolean> booleans) {
        double r = 0;
        for (boolean b : booleans)
            r += b ? 1 : -1;
        return r;
    }
}
