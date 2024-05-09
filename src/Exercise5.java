import java.util.Scanner;
public class Exercise5 {
    public static void main(String[] args) {
        char[] charArray = {'1','2','3','4','5','6','7','8','9'};
        int condition=0;
        char symbol;
        boolean turn=false;
        boolean isWinner;
        do {
            printBoard(charArray);
            symbol= whoseTurnIsIt(turn);
            System.out.println("The turn is:"+ symbol);
            int place=getPositionFromUser(charArray);
            isWinner = placeSymbolOnBoard(charArray,place,symbol);
            if (isWinner){
                printBoard(charArray);
                break;
            }
            else {
                condition++;
            }
            turn= !turn;
        }while (condition<9);
        if (condition==9){
            System.out.println("It's a TIE!");
        }

    }

    public static char whoseTurnIsIt(boolean turn){
        char symbol;
        if (!turn){
            symbol='X';
        }
        else{
            symbol='O';
        }
        return symbol;
    }

    public static void printBoard(char[]charArray){
        for (int i=0;i<charArray.length/3;i++){
            for (int j=i*3;j<i*3+3;j++){
                System.out.print(charArray[j]+ "\t");
            }
            System.out.println();
        }
    }

    public static boolean isAvailable(char [] gameBoard, int indexToCheck){
        boolean checkPlace = true;
        if(indexToCheck>0 && indexToCheck<9){
            if(gameBoard[indexToCheck-1]=='X' || gameBoard[indexToCheck-1]=='O'){
                checkPlace=false;
            }
        }
        return checkPlace;
    }

    public static int getPositionFromUser(char[] gameBoard){
        Scanner scanner = new Scanner(System.in);
        int place;
        do{
            System.out.println("Enter your desired position: ");
            place = scanner.nextInt();
            if (!isAvailable(gameBoard, place)){
                System.out.println("this spot " + place +" is not available try again");
                printBoard(gameBoard);
            }
        }while((place<1 || place>9) || !isAvailable(gameBoard, place));
        return place;
    }

    public static char checkWinner(char[]gameBoard){
        char isWinner;
        isWinner = checkRow(gameBoard);
        if (isWinner=='-'){
            isWinner = checkColumn(gameBoard);
        }
        if (isWinner=='-'){
            isWinner = checkDiagonal(gameBoard);
        }
        return isWinner;
    }
    public static char checkRow(char[]gameBoard){
        char isWinner ='-';
        for(int i = 0; i<gameBoard.length; i+=3){
            if(gameBoard[i] == gameBoard[i+1]){
                if(gameBoard[i+1]==gameBoard[i+2]){
                    isWinner=gameBoard[i];
                    break;
                }
            }
        }
        return isWinner;
    }
    public static char checkColumn(char[]gameBoard){
        char isWinner ='-';
        for(int i = 0; i<gameBoard.length/3; i++){
            if(gameBoard[i] == gameBoard[i+3]){
                if(gameBoard[i+3]==gameBoard[i+6]){
                    isWinner=gameBoard[i];
                    break;
                }
            }
        }
        return isWinner;
    }
    public static char checkDiagonal(char[]gameBoard){
        char isWinner ='-';
        int i = 0;
        if(gameBoard[i] == gameBoard[i+4]){
            if(gameBoard[i+4]==gameBoard[i+8]){
                isWinner=gameBoard[i];
            }

        }  if (gameBoard[i+2]==gameBoard[i+4]) {
            if (gameBoard[i+4]==gameBoard[i+6]){
                isWinner=gameBoard[i+2];
            }
        }
        return isWinner;
    }
    public static boolean placeSymbolOnBoard(char [] charArray ,int place ,char symbol){
        boolean isWinner=false;
        boolean checkPlace=isAvailable(charArray,place);
        if (checkPlace){
            charArray[place-1]=symbol;
        }
        char symbolOfWining=checkWinner(charArray);
        if (symbolOfWining!='-'){
            System.out.println("AND THE WINNER IS: "+ symbolOfWining);
            isWinner=true;
        }

        return isWinner;
    }
}
