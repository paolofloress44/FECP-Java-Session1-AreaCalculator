package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Area Calculator ===");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");
        System.out.print("Choose a shape (1-3): ");

        int shapeChoice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                shapeChoice = scanner.nextInt();
                scanner.nextLine();
                if (shapeChoice >= 1 && shapeChoice <= 3) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    System.out.print("Choose a shape (1-3): ");
                }
            } else {
                System.out.println("Invalid input. Please enter a number (1, 2, or 3).");
                scanner.next();
                scanner.nextLine();
                System.out.print("Choose a shape (1-3): ");
            }
        }

        double area = 0.0;

        switch (shapeChoice) {
            case 1:
                double radius = getDoubleInput(scanner, "Enter the radius: ");
                area = calculateCircleArea(radius);
                System.out.printf("Area of the circle: %.2f%n", area);
                break;

            case 2:
                double base = getDoubleInput(scanner, "Enter the base: ");
                double height = getDoubleInput(scanner, "Enter the height: ");
                area = calculateTriangleArea(base, height);
                System.out.printf("Area of the triangle: %.2f%n", area);
                break;

            case 3:
                double length = getDoubleInput(scanner, "Enter the length: ");
                double width = getDoubleInput(scanner, "Enter the width: ");
                area = calculateRectangleArea(length, width);
                System.out.printf("Area of the rectangle: %.2f%n", area);
                break;
        }

        scanner.close();
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        double value = 0.0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                scanner.nextLine();
                if (value >= 0) {
                    break;
                } else {
                    System.out.println("Dimension cannot be negative. Please enter a non-negative number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                scanner.nextLine();
            }
        }
        return value;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}