import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        int[] dataPoints = new int[100];

        // Populate dataPoints array with random values between 1 and 100
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rnd.nextInt(100) + 1;
        }

        // Display dataPoints array
        System.out.print("DataPoints: ");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        // Calculate sum and average of dataPoints array
        int sum = sum(dataPoints);
        double average = (double) sum / dataPoints.length;
        System.out.printf("The sum of the random array dataPoints is: %d%n", sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        // Linear scan (search)
        int userValue = SafeInput.getRangedInt(scanner, "Enter an integer between 1 and 100: ", 1, 100);
        int index = occuranceScan(dataPoints, userValue);

        if (index != -1) {
            System.out.printf("The value %d was found at array index %d.%n", userValue, index);
        } else {
            System.out.printf("The value %d was not found in the dataPoints array.%n", userValue);
        }

        // Find minimum and maximum values
        int min = min(dataPoints);
        int max = max(dataPoints);

        // Display minimum and maximum values
        System.out.printf("The minimum value in the dataPoints array is: %d%n", min);
        System.out.printf("The maximum value in the dataPoints array is: %d%n", max);

        // Calculate and display the average of dataPoints array using the getAverage method
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

        // Close the scanner
        scanner.close();
    }

    public static double getAverage(int[] values) {
        return (double) sum(values) / values.length;
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public static int occuranceScan(int[] values, int target) {
        int count = 0;
        for (int value : values) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static boolean contains(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }
}
