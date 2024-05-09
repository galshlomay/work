import java.util.Scanner;
public class Exercise2 {
        public static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            String phoneNumber = scanner.nextLine();
            String correctPhoneNumber = correctPhoneNumber(phoneNumber);
            System.out.println(correctPhoneNumber);
        }

        public static String correctPhoneNumber(String phoneNumber) {
            int length = phoneNumber.length();
            String correctPhoneNumber = "";
            if (length == 11 && phoneNumber.charAt(3) == '-' && phoneNumber.startsWith("05")) return phoneNumber;
            else if (length == 10 && phoneNumber.startsWith("05")) {
                correctPhoneNumber = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3);
                return correctPhoneNumber;
            } else if (length == 12 && phoneNumber.startsWith("9725")) {
                correctPhoneNumber = "0" + phoneNumber.substring(3, 5) + "-" + phoneNumber.substring(5);
                return correctPhoneNumber;
            }
            return correctPhoneNumber;
        }
    }

