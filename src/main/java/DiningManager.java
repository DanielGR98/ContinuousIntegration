import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DiningManager {

    // Declare and initialize the menu with meal options and prices
    private static final Map<String, Double> menu = new HashMap<>();

    static {
        menu.put("Spaghetti", 8.99);
        menu.put("Pizza", 10.99);
        menu.put("Dumplings", 7.99);
        menu.put("Sushi", 12.99);
        menu.put("Cake", 5.99);
        menu.put("Chef's Special", 20.99);
        
        // Add more meals to the menu as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> selectedMeals = new HashMap<>();

        // Display the menu to the user
        System.out.println("Welcome to the Dining Experience Manager!");
        System.out.println("Menu:");
        for (String meal : menu.keySet()) {
            System.out.println(meal + " - $" + menu.get(meal));
        }

        // Get meal selections and quantities from the user
        for (String meal : menu.keySet()) {
            System.out.print("Enter the quantity for " + meal + ": ");
            int quantity = scanner.nextInt();

            // Validate the quantity
            while (quantity < 0 || quantity > 100) {
                System.out.println("Invalid quantity. Please enter a positive integer between 1 and 100.");
                System.out.print("Enter the quantity for " + meal + ": ");
                quantity = scanner.nextInt();
            }

            selectedMeals.put(meal, quantity);
        }

        // Calculate the total cost and apply discounts
        double totalCost = calculateTotalCost(selectedMeals);

        // Display the order summary to the user
        System.out.println("\nOrder Summary:");
        for (String meal : selectedMeals.keySet()) {
            System.out.println(meal + " x " + selectedMeals.get(meal));
        }
        System.out.println("Total Cost: $" + totalCost);

        scanner.close();
    }

    public static double calculateTotalCost(Map<String, Integer> selectedMeals) {
        double totalCost = 0;

        for (String meal : selectedMeals.keySet()) {
            if (menu.containsKey(meal)) {
                int quantity = selectedMeals.get(meal);
                double baseCost = menu.get(meal);

                // Apply surcharge for Chef's Specials category
                if (isChefSpecial(meal)) {
                    baseCost *= 1.05;
                }

                totalCost += baseCost * quantity;
            }
        }

        // Apply discounts based on the total quantity
        int totalQuantity = selectedMeals.values().stream().mapToInt(Integer::intValue).sum();
        if (totalQuantity > 5 && totalQuantity <= 10) {
            totalCost *= 0.9; // 10% discount
        } else if (totalQuantity > 10) {
            totalCost *= 0.8; // 20% discount
        }

        // Apply special offer discounts
        if (totalCost > 100) {
            totalCost -= 25;
        } else if (totalCost > 50) {
            totalCost -= 10;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        totalCost = Double.parseDouble(decimalFormat.format(totalCost));

        return totalCost;
    }

    private static boolean isChefSpecial(String meal) {
        // Implement this method to check if the meal belongs to the Chef's Special category
        // You can use a list or a separate map to keep track of Chef's Specials
        // For simplicity, we'll assume all meals with "Special" in their name are Chef's Specials
        return meal.toLowerCase().contains("special");
    }
}