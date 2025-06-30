
import java.util.*;

public class InvestmentProjection {

    // Cache to store previously computed year values for memoization
    private static Map<Integer, Double> yearlyProjectionCache = new HashMap<>();

    public static double calculateFutureValue(double initialInvestment, double annualGrowthRate, int investmentYears) {
        // Return cached value if already computed
        if (yearlyProjectionCache.containsKey(investmentYears)) {
            return yearlyProjectionCache.get(investmentYears);
        }

        // Base case: return initial amount when years remaining is 0
        if (investmentYears == 0) {
            return initialInvestment;
        }

        // Recursive case: calculate with one less year
        double futureValue = calculateFutureValue(initialInvestment * (1 + annualGrowthRate),annualGrowthRate,investmentYears - 1
        );
        
        // Store computed value in cache before returning
        yearlyProjectionCache.put(investmentYears, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("\nInvestment Growth Projection Calculator");
        
        System.out.print("Enter initial investment amount: $");
        double startingAmount = userInput.nextDouble();

        System.out.print("Enter annual interest rate (e.g., 0.05 for 5%): ");
        double interestRate = userInput.nextDouble();

        System.out.print("Enter investment duration (years): ");
        int years = userInput.nextInt();

        double projectedValue = calculateFutureValue(startingAmount, interestRate, years);
        System.out.printf("\nProjected value after %d years: $%.2f%n", years, projectedValue);

        userInput.close();
    }
}
