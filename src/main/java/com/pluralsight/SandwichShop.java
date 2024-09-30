package com.pluralsight;

import java.util.*;

public class SandwichShop {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double sandwichPrice = getSandwichPrice();
        int age = getUserAge();
        double totalCost = calculateTotalCost(sandwichPrice, age);
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

    public static int getUserAge() {
        System.out.print("Enter your age: ");
        return scanner.nextInt();
    }

    public static double calculateTotalCost(double sandwichPrice, int age) {
        double discount = 0;

        if (age <= 17) {
            discount = 0.10; // 10% discount for students
        } else if (age >= 65) {
            discount = 0.20; // 20% discount for seniors
        }

        double discountAmount = sandwichPrice * discount;
        return sandwichPrice - discountAmount;
    }

    public static void displayTotalCost(double totalCost) {
        System.out.printf("The total cost of your sandwich is: $%.2f%n", totalCost);
    }
}

