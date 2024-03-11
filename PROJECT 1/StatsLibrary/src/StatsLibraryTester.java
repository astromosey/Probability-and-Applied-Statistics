import java.util.ArrayList;  // Import ArrayList
import java.util.Arrays;
public class StatsLibraryTester {
    public static void main(String[] args) {
        StatsLibrary lib = new StatsLibrary();

        ArrayList<Integer> SetA = new ArrayList<>(Arrays.asList(1, 3, 5, 6, 8, 8));
        ArrayList<Integer> SetB = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 7));
        ArrayList<Integer> UniversalSet = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            UniversalSet.add(i);
        }
        //Mean test
        System.out.println("Mean (Set A): " + lib.mean(SetA));
        System.out.println("Mean (Set B): " + lib.mean(SetB));
        //Median test
        System.out.println("Median (Set A): " + lib.median(SetA));
        System.out.println("Median (Set B): " + lib.median(SetB));
        //Mode test
        System.out.println("Mode (Set A): " + lib.mode(SetA));
        System.out.println("Mode (Set B): " + lib.mode(SetB));
        // SD & Variance test
        System.out.println("Standard Deviation (Set A): " + lib.standardDeviation(SetA));
        System.out.println("Variance (Set B): " + lib.variance(SetB));
        //Set Operations test
        System.out.println("Complement (Set A, Universal Set): " + lib.complement(SetA, UniversalSet));
        System.out.println("Intersection of Sets: " + lib.intersection(SetA, SetB));
        System.out.println("Union of Sets: " + lib.union(SetA, SetB));
        //Independency test
        boolean dependent = lib.Dependency(SetA, SetB);
        System.out.print("Are Set A and B independent or dependent?: ");
        if (dependent) {
            System.out.println("Dependent");
        } else {
            System.out.println("Independent");
        }
        //Factorial test (BigIntegers)
        System.out.println("Factorial (BigInteger) of 5: = " + lib.factorial(5));
        //Factorial test (Long)
        System.out.println("Factorial (Long) of 5: " + lib.factorialLong(5));
        //Permutation & combination test
        System.out.println("Permutation of 13 and 4 = " + lib.permutation(13, 4));
        System.out.println("Combination of 13 and 4 = " + lib.combination(13, 4));
        //Conditional Probability test
        ArrayList<Integer> eventA = new ArrayList<>(Arrays.asList(3, 6, 8));
        ArrayList<Integer> eventB = new ArrayList<>(Arrays.asList(1, 2, 4, 6, 7));

        double conditionalProb = lib.conditionalProbability(eventA, eventB);
        if (conditionalProb >= 0) {
            System.out.println("Conditional Probability of A given B: " + conditionalProb);
        } else {
            System.out.println("Error calculating conditional probability.");
        }
        //Binomial distribution tests
        System.out.println("Binomial Distribution (p=0.90, q=0.20, n=8, y=5): " + lib.binomialDistribution(8, 5, 0.90));
        System.out.println("Binomial Distribution - Expected Value: " + lib.binomialExpectedValue(8, 0.90));
        System.out.println("Binomial Distribution - Variance: " + lib.binomialVariance(8, 0.90));
        //Geometric distribution tests
        System.out.println("Geometric Distribution (p=0.06, q=0.94, n=3): " + lib.geometricDistribution(3, 0.06));
        System.out.println("Geometric Distribution - Expected Value: " + lib.geometricExpectedValue(0.06));
        System.out.println("Geometric Distribution - Variance: " + lib.geometricVariance(0.06));
        //Hypergeometric distribution tests
        System.out.println("Hypergeometric Distribution (n=10, m=5, r=3, y=2): " + lib.hypergeometricDistribution(10, 5, 3, 2));
        System.out.println("Hypergeometric Distribution - Expected Value: " + lib.hypergeometricExpectedValue(10, 5, 3));
        System.out.println("Hypergeometric Distribution - Variance: " + lib.hypergeometricVariance(10, 5, 3));
     // Negative binomial distribution tests
        System.out.println("Negative Binomial Distribution (r=3, p=0.2, x=5): " + lib.negativeBinomialDistribution(3, 0.2, 5));
        System.out.println("Negative Binomial Distribution - Expected Value: " + lib.negativeBinomialExpectedValue(3, 0.2));
        System.out.println("Negative Binomial Distribution - Variance: " + lib.negativeBinomialVariance(3, 0.2));  
    }
}