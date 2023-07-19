import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class NewspaperSubscriptionCalculator {

    // Define a map to store the subscription prices for each newspaper
    private static Map<String, double[]> newspaperData = new HashMap<>();

    public static void main(String[] args) {
        // Initialize newspaperData with the subscription prices for each newspaper
        newspaperData.put("TOI", new double[]{3, 3, 3, 3, 3, 5, 6});
        newspaperData.put("Hindu", new double[]{2.5, 2.5, 2.5, 2.5, 2.5, 4, 4});
        newspaperData.put("ET", new double[]{4, 4, 4, 4, 4, 4, 10});
        newspaperData.put("BM", new double[]{1.5, 1.5, 1.5, 1.5, 1.5, 1.5, 1.5});
        newspaperData.put("HT", new double[]{2, 2, 2, 2, 2, 4, 4});

        // Create a new Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the weekly budget
        System.out.print("Enter the weekly budget: ");
        double budget = scanner.nextDouble();

        // Define the number of newspaper subscriptions allowed
        int numSubscriptions = 2;

        // Get all possible combinations of subscriptions within the given budget
        List<List<String>> combinations = getCombinations(newspaperData, numSubscriptions, budget);

        // Display the output
        System.out.print("Possible combinations of " + numSubscriptions + " subscriptions within the " + budget + ": ");
        for (List<String> combination : combinations) {
            System.out.print("{");
            for (int i = 0; i < combination.size(); i++) {
                System.out.print("\"" + combination.get(i) + "\"");
                if (i < combination.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}, ");
        }

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to get all possible combinations of newspaper subscriptions within the given budget
    public static List<List<String>> getCombinations(Map<String, double[]> newspaperData, int numSubscriptions, double budget) {
        Set<List<String>> combinations = new HashSet<>();

        // Loop through each pair of newspapers (entry1 and entry2) in newspaperData
        for (Map.Entry<String, double[]> entry1 : newspaperData.entrySet()) {
            for (Map.Entry<String, double[]> entry2 : newspaperData.entrySet()) {
                // Avoid combinations of the same newspaper
                if (!entry1.getKey().equals(entry2.getKey())) {
                    // Calculate the total expenses for each newspaper
                    double totalExpense1 = calculateTotalExpense(entry1.getValue(), numSubscriptions);
                    double totalExpense2 = calculateTotalExpense(entry2.getValue(), numSubscriptions);
                    double combinedTotal = totalExpense1 + totalExpense2;

                    // Check if the combined total is within the budget
                    if (combinedTotal <= budget) {
                        // Create a combination list with two newspapers and add it to the set of combinations
                        List<String> combination = new ArrayList<>();
                        combination.add(entry1.getKey());
                        combination.add(entry2.getKey());
                        combinations.add(combination);
                    }
                }
            }
        }

        // Convert the set of combinations to a list and return it
        return new ArrayList<>(combinations);
    }

    // Method to calculate the total expense of a newspaper subscription for a given number of days
    private static double calculateTotalExpense(double[] prices, int numSubscriptions) {
        double total = 0;
        for (int i = 0; i < numSubscriptions && i < prices.length; i++) {
            total += prices[i];
        }
        return total;
    }
}

