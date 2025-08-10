package gfg160Days_DSA;

public class Day076_PowerCalculator {
    // Computes b^e for double b and long e (to cover -109..109 safely when using integer exponent)
    // We accept e as a long to be exact for integer exponents, and we also handle negative exponents.
    public static double power(double b, long e) {
        // Special cases
        if (Double.isNaN(b) || Double.isNaN((double) e)) {
            return Double.NaN;
        }
        if (b == 0.0) {
            // 0^e is 0 for e > 0; for e <= 0, it's undefined (inf) but constraints say be within
            // range and "Either b is not zero or e > 0" ensures we won't call with b==0 and e<=0.
            if (e > 0) return 0.0;
            // For completeness, return NaN for non-positive exponents with zero base
            return Double.NaN;
        }
        // If exponent is 0
        if (e == 0) return 1.0;

        // If exponent is negative, compute reciprocal
        boolean negativeExponent = e < 0;
        long absExp = Math.abs(e);

        double result = 1.0;
        double base = b;

        // Exponentiation by squaring for integer exponent
        long exp = absExp;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            base *= base;
            exp >>= 1;
        }

        if (negativeExponent) {
            result = 1.0 / result;
        }
        // Optional: clamp to -104 <= be <= 104 is a constraint on be, but we won't enforce it here.
        return result;
    }

    // Convenience overload for int e
    public static double power(double b, int e) {
        return power(b, (long) e);
    }

    // Example usage
    public static void main(String[] args) {
        // Test cases matching examples
        System.out.printf("power(3.0, 5)  = %.5f%n", power(3.0, 5));        // 243.00000
        System.out.printf("power(0.55, 3) = %.5f%n", power(0.55, 3));       // 0.16638
        System.out.printf("power(-0.67, -7) = %.5f%n", power(-0.67, -7));   // -16.49971 (approx)

        // Additional checks
        System.out.printf("power(2.0, -3) = %.5f%n", power(2.0, -3));       // 0.12500
    }
}
