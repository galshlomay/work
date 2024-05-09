import java.util.Scanner;
import java.util.Random;
public class Exercise7 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int level;
        int randomLevel = random.nextInt(5,26);
        int [] arrayLevel = new int[]{20,15,10,randomLevel};
        do {
            System.out.println("Welcome to THE GUESSING GAME \n" +
                    "Your objective is to guess the random number i'm thinking about\n" +
                    "The super secret code is made out of 4 different digits between 1-6,\n" +
                    "if you guess the code with identical digits you are fined with 2 tries.\n" +
                    "To start choose one of 4 levels of difficulty using digits 1-4\n" +
                    "1. Easy - 20 guesses\n" +
                    "2. Medium - 15 guesses\n" +
                    "3. Hard - 10 guesses\n" +
                    "4. Surprise - you get random amount of guesses between 5-25\n");
            level = scanner.nextInt();
        }while (level>4||level<1);
        System.out.println("Good Luck!");
        int guessesCounter = arrayLevel[level-1];
        String secretCode=randomCode();
        if (gameManagement(guessesCounter,secretCode,level)){
            System.out.println("You won! now go ahead and write it in your resume.");
        }
        else {
            System.out.println("There's nothing wrong with being a loser,\n" +
                    "it just depends on how good you are at it. -Billie Joe Armstrong");
        }
    }
    public static String randomCode(){
        Random random = new Random();
        String secretCode="";
        String checkDup;
        boolean isDuplicate=true;
        final int CODE_SIZE =4;
        for (int i=0;i<CODE_SIZE;i++){
            while (isDuplicate) {
                checkDup = String.valueOf(random.nextInt(1, 7));
                if (!secretCode.contains(checkDup)) {
                    secretCode+=checkDup;
                    isDuplicate=false;
                }
            }
            isDuplicate=true;
        }
        System.out.println(secretCode);
        return secretCode;
    }

    public static String getUserGuess(){
        Scanner scanner = new Scanner(System.in);
        String userGuess;
        do {
            System.out.println("Please enter 4 numbers between 1 - 6");
            userGuess = scanner.nextLine();
        }while (userGuess.length()!=4 || !isBetweenOneToSix(userGuess));

        return userGuess;
    }
    public static boolean isBetweenOneToSix(String userGuess){
        boolean isValid=true;
        String digits ="123456";
        for (int i=0;i<userGuess.length();i++){
            if (!digits.contains(userGuess.charAt(i) + "")) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static boolean checkGuess(String userGuess,String secretCode){
        boolean isWinner =false;
        int counterExactly=0;
        int counterPartially=0;
        if (userGuess.equals(secretCode)){
            isWinner =true;
        }else {
            for (int i=0;i<secretCode.length();i++){
                for (int j=0;j<userGuess.length();j++){
                    String checkSecretGuess= secretCode.charAt(i)+"";
                    String checkUserGuess= userGuess.charAt(j)+"";
                    if (checkUserGuess.equals(checkSecretGuess)){
                        if (i==j){
                            counterExactly++;
                            break;
                        }}
                }
                if (secretCode.contains(userGuess.charAt(i) + "")){
                    counterPartially++;
                }
            }
            counterPartially = counterPartially-counterExactly;
            if (counterPartially<0){
                counterPartially*=-1;
            }
            System.out.println("DAMN! you guessed " + counterExactly+" accurate guesses, but "+ counterPartially + " inaccurate guesses.");
        }
        return isWinner;
    }
    public static boolean isDuplicate(String userGuess){
        boolean isDuplicate=true;
        for (int i=0;i<userGuess.length();i++){
            for (int j=i+1;j<userGuess.length();j++){
                String tempDigitI = userGuess.charAt(i)+"";
                String tempDigitJ = userGuess.charAt(j)+"";
                if (tempDigitJ.equals(tempDigitI)){
                    isDuplicate = false;
                    break;
                }
            }
            if (!isDuplicate){
                break;
            }
        }
        return isDuplicate;
    }
    public static boolean gameManagement(int guessesCounter,String secretCode,int level){
        boolean isWin = false;
        while (guessesCounter>0){
            String userGuess=getUserGuess();
            if (checkGuess(secretCode,userGuess)){
                isWin=true;
                break;
            }
            if(!isDuplicate(userGuess)){
                guessesCounter-=2;
            }
            else {
                guessesCounter--;
            }

            if (level!=4){
                System.out.println("remaining guesses: " + guessesCounter);
            }

        }
        return isWin;
    }
}
