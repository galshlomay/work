public class Exercise4 {
    public static void main(String[] args) {
        int[] array = {1,3,6,11,10,9,4,2,0};
        System.out.println( arrayUpAndDown(array));
    }
    public static int arrayUpAndDown(int[] array){
        int checkUpDown = -1;
        boolean flag = false;
        int i;
        for (i=0;i<array.length-1;i++) {
            checkUpDown = i;
            if(array[i] < array[i + 1]) {
                flag = true;
            }
            else {
                flag=false;
                break;
            }
        }
        if (i == array.length - 1) {
            checkUpDown=-1;
        }
        if (!flag){
            for (i=checkUpDown;i<array.length-1;i++){
                if(array[i]>array[i+1]){
                    flag=true;
                }
                else {
                    flag=false;
                    break;
                }
            }
            if (!flag){
                checkUpDown=-1;
            }
        }

        return checkUpDown;
    }

}
