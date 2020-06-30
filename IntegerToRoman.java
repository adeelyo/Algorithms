/**
 * Created by Adeel Masood on 7/1/2020.
 */
import java.util.*;
public class IntegerToRoman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        String romanString = intToRoman(number);
        System.out.println("roman equivalent for number("+number+") is: "+romanString);
    }
    public static String intToRoman(int A) {
        int temp = A;
        int ones=1;
        int fives = 5;
        ArrayList<String> stringList = new ArrayList<String>();
        // System.out.println("Check1");
        while(temp>0) {
            // System.out.println("Check2");
            StringBuilder myBuilder = new StringBuilder();
            int lastDigit = temp%10;
            switch(lastDigit){
                case 1:
                    myBuilder.append(returnCharacter(ones));
                    break;
                case 2:
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones));
                    break;
                case 3:
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones));
                    break;
                case 4:
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(fives));
                    break;
                case 5:
                    myBuilder.append(returnCharacter(fives));
                    break;
                case 6:
                    myBuilder.append(returnCharacter(fives));
                    myBuilder.append(returnCharacter(ones));
                    break;
                case 7:
                    myBuilder.append(returnCharacter(fives));
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones));
                    break;
                case 8:
                    myBuilder.append(returnCharacter(fives));
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones));
                    break;
                case 9:
                    myBuilder.append(returnCharacter(ones));
                    myBuilder.append(returnCharacter(ones*10));
                    break;
                case 0:
                    break;
            }
            stringList.add(myBuilder.toString());
            ones*=10;
            fives*=10;
            temp/=10;
            //   System.out.println("Check3");
        }
        // System.out.println("Check4");
        // Collections.reverse(stringList);
        StringBuilder finalBuilder = new StringBuilder();
        for(int i=stringList.size()-1;i>=0;i--) {
            finalBuilder.append(stringList.get(i));
        }
        // System.out.println(finalBuilder.toString());
        return finalBuilder.toString();
    }
    public static char returnCharacter(int number) {
        switch(number){
            case 1:
                return 'I';
            case 5:
                return 'V';
            case 10:
                return 'X';
            case 50:
                return 'L';
            case 100:
                return 'C';
            case 500:
                return 'D';
            case 1000:
                return 'M';
            default:
                return 'I';
        }
    }

}
