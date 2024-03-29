import java.util.Scanner;

public class SafeInput {
    /**
     * Get a non-zero length String input from the user.
     *
     * @param pipe   a Scanner object opened to read from System.in
     * @param prompt prompt for the user
     * @return a non-zero length String input from the user
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retInt;
        do {
            System.out.print(prompt + " (" + low + " - " + high + "): ");
            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer within the range.");
                System.out.print(prompt + " (" + low + " - " + high + "): ");
                pipe.next(); // Consume invalid input
            }
            retInt = pipe.nextInt();
        } while (retInt < low || retInt > high);
        return retInt;
    }
}
