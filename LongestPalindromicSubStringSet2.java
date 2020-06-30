/**
 * Created by Adeel Masood on 7/1/2020.
 */
import java.util.*;
public class LongestPalindromicSubStringSet2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text= in.nextLine();
        String result = LPS(text);
        System.out.println("Longest palindromic substring is: "+result);
    }
    public static String LPS(String text)  {
        int next, previous;
        int length = text.length();
        int maxLength = 1;
        int start =0;
        for(int i=1;i<length;i++) {
            next = i;
            previous = i-1;
            while(next<length && previous >=0 && text.charAt(next) == text.charAt(previous)){
                if(next-previous+1>maxLength){
                    start = previous;
                    maxLength = next - previous +1;
                }
                next++;
                previous--;
            }

            next = i+1;
            previous = i-1;
            while(next<length && previous >=0 && text.charAt(next)==text.charAt(previous)) {
                if(next-previous+1>maxLength){
                    start = previous;
                    maxLength = next - previous +1;
                }
                next++;
                previous--;
            }

        }
        return printString(text, start, start+maxLength-1);
    }
    public static String printString(String text, int start, int end) {
//        System.out.println("Start: "+start);
//        System.out.println("End: "+end);
        return text.substring(start,end+1);
    }
}
