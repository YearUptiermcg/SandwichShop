package com.pluralsight;

import java.util.*;

public class SandwichShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double sandwichPrice = getSandwichPrice();
        double loadedCost = getLoadedCost();
        int age = getUserAge();
        double totalCost = calculateTotalCost(sandwichPrice, loadedCost, age);
        displayTotalCost(totalCost);
    }

    public static double getSandwichPrice() {
        System.out.println("Select the size of the sandwich:");
        System.out.println("1: Regular ($5.45)");
        System.out.println("2: Large ($8.95)");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();
        if (choice == 1) {
            return 5.45; // Regular
        } else {
            return 8.95; // Large
        }
    }

    public static double getLoadedCost() {
        System.out.print("Would you like your sandwich loaded? (yes/no): ");
        String loadedInput = scanner.next();

        if (loadedInput.equals("yes")) {
            System.out.println("That will be $1 extra.");
            return 1.00; // Loaded cost
        } else {
            System.out.println("There will be no extra charge.");
            return 0.0; // No additional cost for non-loaded
        }
    }

    public static int getUserAge() {
        System.out.print("Enter your age: ");
        return scanner.nextInt();
    }

    public static double calculateTotalCost(double sandwichPrice, double loadedCost, int age) {
        double totalPrice = sandwichPrice + loadedCost; // Add loaded cost if applicable
        double discount = 0;

        if (age <= 17) {
            discount = 0.10; // 10% discount for students
            System.out.println("You qualify for a 10% student discount.");
        } else if (age >= 65) {
            discount = 0.20; // 20% discount for seniors
            System.out.println("You qualify for a 20% senior discount.");
        } else {
            System.out.println("You do not qualify for a discount.");
        }

        double discountAmount = totalPrice * discount;
        return totalPrice - discountAmount; // Apply discount
    }
    public static void displayTotalCost(double totalCost) {
        System.out.printf("The total cost of your sandwich is: $%.2f", totalCost);
    }
}
