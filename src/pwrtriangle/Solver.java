package pwrtriangle;

/**
 * Power triangle solver
 *
 * This class solves the power triangle. The power triangle is a right triangle
 * with hypotenuse S (apparent power, VA) and legs P (active power, W) and Q
 * (reactive power VAr). The triangle angle is specified by the PF (power
 * factor) which is defined as the cosine of the triangle angle. Applying basic
 * trigonometry we have:
 *
 *     cos theta = PF
 *     sin theta = sqrt(1 - PF^2)
 *     tan theta = Q / P = sin theta / cos theta
 *
 * From these equations we have three quantities of interest: P, Q, PF. If we
 * have two we can solve for the other. This class provides functions that solve
 * for the three cases.
 */
public class Solver {

    /**
     * Constructor is private as this is a package of static functions
     */
    private Solver() {}

    /**
     * Solve power triangle for PF given P and Q
     * @param p active power
     * @param q reactive power
     * @return power factor
     */
    static public double solveForPf(double p, double q) {

        double num = p*p;
        double den = p*p + q*q;
        return Math.sqrt(num / den);
    }

    /**
     * Solve power triangle for Q given P and PF
     * @param p active power
     * @param pf power factor
     * @return reactive power
     */
    static public double solveForQ(double p, double pf) {

        double sin_theta = Math.sqrt(1 - pf*pf);
        return p * sin_theta / pf;
    }

    /**
     * Solve power triangle for P given Q and PF
     * @param q reactive power
     * @param pf power factor
     * @return active power
     */
    static public double solveForP(double q, double pf) {

        double sin_theta = Math.sqrt(1 - pf*pf);
        return q * pf / sin_theta;
    }
}
