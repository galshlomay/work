public class Exercise3 {
    public static void main(String[] args) {
    }

    public static int [] removeDuplicate(int [] originalArray){
        boolean checkDuplicates=true;
        String str="";
        int counter = 0;
        for (int i=0;i<originalArray.length;i++) {
            if (str.contains(originalArray[i] + "") == true) {
                continue;
            }
            for (int j = i + 1; j < originalArray.length; j++) {
                if (originalArray[i] == originalArray[j]) {
                    counter++;
                }
                if (str.contains(originalArray[i] + "") == false) {
                    str += originalArray[i] + "";
                }
            }
        }
        int [] newArray = new int[originalArray.length-counter];
        int myIndex=originalArray.length-counter-1;
        for (int i=originalArray.length-1;i>=0;i--){
            for (int j=i-1;j>=0;j--){
                if (originalArray[i]==originalArray[j]){
                    checkDuplicates=false;
                    break;
                }
            }
            if (!checkDuplicates){
                for (int z=0;z<newArray.length-1;z++) {
                    if (newArray[z]!=newArray[z+1]){
                        checkDuplicates=true;
                    }
                    else {
                        checkDuplicates=false;
                        break;
                    }
                }
                if (checkDuplicates) {
                    newArray[myIndex] = originalArray[i];
                    myIndex--;
                }
            }
            else {
                newArray[myIndex] = originalArray[i];
                myIndex--;
            }
            checkDuplicates=true;
        }


        return newArray;
    }
}

