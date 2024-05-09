import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        valuesBiggerThanAverage();
    }

    public static void valuesBiggerThanAverage() {
        final int ARRAY_SIZE = 10;
        Scanner scanner = new Scanner(System.in);
        int average = 0;
        System.out.println("Enter 10 numbers here: ");

        int[] userInput = new int[ARRAY_SIZE];

        for (int i = 0; i < userInput.length; i++) {
            System.out.println("please enter the " + (i + 1) + " number");
            userInput[i] = scanner.nextInt();
            average += userInput[i];
        }
        average /= userInput.length;
        System.out.println("These are the grades whose higher than the average of your grades: ");
        for (int j = 0; j < userInput.length; j++) {
            if (average < userInput[j]) {
                System.out.print(userInput[j] + " ");

            }
        }

    }
}


