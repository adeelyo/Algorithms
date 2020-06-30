/**
 * Created by Adeel Masood on 7/1/2020.
 */
import java.util.*;
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String romanString = in.nextLine();
        int number = romanToInt(romanString);
        System.out.println("The number for roman("+romanString+") is: "+number);
    }
    public static int romanToInt(String A) {
        HashMap<Character, Integer> romanMap= new HashMap<Character, Integer>();
        romanMap.put('X', 10);
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int number =0;
        int length = A.length();
        for(int i=0;i<length;i++) {
            char characterRightNow = Character.toUpperCase(A.charAt(i));
            int j =i+1;
            if(j<length) {
                char nextCharacter = Character.toUpperCase(A.charAt(i+1));
                // System.out.println("Currect character: "+characterRightNow);
                // System.out.println("Its number value is: "+romanMap.get(characterRightNow));
                // System.out.println("next Character: "+nextCharacter);
                // System.out.println("its number value is: "+romanMap.get(nextCharacter));
                if(romanMap.get(nextCharacter)>romanMap.get(characterRightNow)) {
                    // System.out.println("inside 1");
                    number = number+(romanMap.get(characterRightNow)*(-1));
                }else if(romanMap.get(nextCharacter) <= romanMap.get(characterRightNow)) {
                    // System.out.println("inside 2");
                    number = number + romanMap.get(characterRightNow);
                }
            }
            if(j==length) {
                // System.out.println("Current Character: "+characterRightNow);
                // System.out.println("its number value is: "+romanMap.get(characterRightNow));
                number+= romanMap.get(characterRightNow);
            }
        }
        return number;
    }
}
