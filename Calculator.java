import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Simple Calculator ---");
            System.out.print("Enter first number: ");
            double num1 = getValidNumber(scanner);

            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = getValidOperator(scanner);

            System.out.print("Enter second number: ");
            double num2 = getValidNumber(scanner);

            double result = performCalculation(num1, num2, operator);
            System.out.printf("Result: %.2f\n", result);

            System.out.print("Do you want to perform another operation? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    // Get a valid number from the user
    private static double getValidNumber(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    // Get a valid operator from the user
    private static char getValidOperator(Scanner scanner) {
        while (true) {
            String input = scanner.next();
            if (input.length() == 1 && "+-*/".contains(input)) {
                return input.charAt(0);
            } else {
                System.out.print("Invalid operator. Please enter one of (+, -, *, /): ");
            }
        }
    }

    // Perform the chosen operation
    private static double performCalculation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                    return 0;
                }
                return num1 / num2;
            default:
                System.out.println("Invalid operator.");
                return 0;
        }
    }
}
