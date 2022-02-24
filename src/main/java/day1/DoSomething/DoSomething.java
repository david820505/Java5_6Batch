package day1.DoSomething;

import java.util.Scanner;

public class DoSomething {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter keyboard value");

        while(true){
            String line = myObj.nextLine();
            if(line.charAt(0) == 'q')
                break;
            if(!isNumeric(line)){
                System.out.println("Please enter valid value");
                continue;
            }
            int num = Integer.valueOf(line);

            System.out.println("The count is: " + countToX(num));  // Output user input
        }
        System.out.println("==========End==========");
    }
    public static int countToX(int x){
        int count = 0;
        for(int i = 0; i<=x;i++){
            count+=i;
        }
        return count;
    }


    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
