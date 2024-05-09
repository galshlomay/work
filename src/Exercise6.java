import java.util.Scanner;
public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a quadratic equation of the form : +/-ax^2+/-bx+/-c=0" );
        String equation = scanner.nextLine();
        if (!checkValidation(equation)){
            System.out.println("The equation you inserted DOES NOT meet the required form of a quadratic equation as we firstly stated: +/-ax^2+/-bx+/-c=0");
        }
        else {
            int a = extractsA(equation);
            int b = extractsB(equation);
            int c = extractsC(equation);
            solvesQuadraticEquation(a,b,c);
        }
    }
    public static boolean checkValidation(String equation){
        boolean isValid=false;
        String digits = "0123456789";
        StringBuilder equationWithoutNumbers= new StringBuilder();
        String [] patternArray = new String[]{"x^2+x+=0","x^2+x-=0","x^2-x-=0","x^2-x+=0","-x^2+x+=0","-x^2+x-=0","-x^2-x-=0","-x^2-x+=0"};
        for (int i=0;i<equation.length();i++){
            if (!digits.contains(equation.charAt(i)+"")){
                equationWithoutNumbers.append(equation.charAt(i));
            } else if (equation.charAt(i)=='2'&&i!=0) {
                if (equation.charAt(i-1)=='^'){
                    equationWithoutNumbers.append(equation.charAt(i));
                }
            }
            else if (equation.charAt(i)=='0'&&i==equation.length()-1){
                if (equation.charAt(i-1)=='='){
                    equationWithoutNumbers.append(equation.charAt(i));
                }
            }
        }
        for (int i=0;i<patternArray.length;i++){
            if (equationWithoutNumbers.toString().equals(patternArray[i])){
                isValid =true;
                break;
            }
        }
        return isValid;
    }

    public static int extractsA(String equation){
        int a;
        int indexOfX;
        indexOfX = equation.indexOf("x");
        if (indexOfX==0){
            a=1;
        } else if (equation.substring(0,indexOfX).equals("-")) {
            a=-1;
        }
        else {
            String findA = equation.substring(0, indexOfX);
            a= Integer.parseInt(findA);
        }
        return a;
    }
    public static int extractsB(String equation){
        int b;
        String findB = equation.substring(equation.indexOf("^")+2);
        findB = findB.substring(0,findB.indexOf("x"));
        if (findB.equals("-")){
            b=-1;
        }
        else if (findB.equals("+")){
            b=1;
        }
        else {
            b = Integer.parseInt(findB);
        }
        return b;
    }
    public static int  extractsC(String equation){
        int c;
        String findC;
        if (equation.indexOf("x-")!=-1){
            findC = equation.substring(equation.indexOf("x-")+1);
            findC = findC.substring(0,findC.indexOf("="));
        }
        else {
            findC = equation.substring(equation.indexOf("x+")+1);
            findC = findC.substring(0,findC.indexOf("="));
        }
        c= Integer.parseInt(findC);
        return c;
    }
    public static void solvesQuadraticEquation(int a,int b,int c){
        double x1;
        double x2;
        double delta;
        delta = ((b * b) - 4 * a * c);
        if (delta<0){
            System.out.println("There is no solution to the equation");
        } else if (delta==0) {
            System.out.println("There is only one solution to the equation: " + (b/(2*a)*-1));

        }
        else {
            x1 = ((-b) - (Math.sqrt(delta))) / (2 * a);
            x2 = ((-b) + (Math.sqrt(delta))) / (2 * a);
            System.out.println("There are two solutions to the equation:" + "x1= " + x1 + " x2= " + x2);
        }
    }

}
