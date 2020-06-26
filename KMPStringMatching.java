/**
 * Created by Adeel Masood on 6/26/2020.
 */
import java.util.*;
public class KMPStringMatching {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String pattern = in.nextLine();
        if(KMP(text, pattern)){
            System.out.println("pattern FOUND in text");
        }else {
            System.out.println("pattern NOT FOUND in text");
        }

    }
    //to create the pattern array which will be used to check prefix and suffix
    public static int[] createTempArray(String pattern) {
        int patternLength = pattern.length();
        int[] patternArray = new int[patternLength];
        int i;
        int j=0;
        for(i=1;i<patternLength; ) {
            if(pattern.charAt(i)==pattern.charAt(j)) {
                patternArray[i] = j+1;
                i++;
                j++;
            }else {
                if(j!=0) {
                    j = patternArray[j-1];
                }else {
                    patternArray[i]=0;
                    i++;
                }
            }
        }
        return patternArray;
    }
    //to do string matching using KMP
    public static boolean KMP(String text, String pattern) {
        int[] patternArray = createTempArray(pattern);
        printArray(patternArray);
        int textLength = text.length();
        int patternLength = pattern.length();
        int i=0;
        int j=0;
        while(i<textLength && j<patternLength){
            if(text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else {
                if(j!=0) {
                    j = patternArray[j-1];
                }else {
                    i++;
                }
            }
        }
        if(j==patternLength) {
            return true;
        }
        return false;
    }
    //to print integer array
    public static void printArray(int[] array) {
        int length = array.length;
        for(int i=0;i<length;i++) {
            if(i==0){
                System.out.print("["+array[i]+", ");
            }else if(i==length-1) {
                System.out.println(array[i]+"]");
            }else {
                System.out.print(array[i]+", ");
            }
        }
    }
}
