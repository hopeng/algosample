package algorithm;

import static java.lang.System.out;

/**
 * Created by hopeng on 30/12/2015.
 */
public class StringToInt {

    public static void main(String args[]) {
        String number = "0130456320";
        int intValue = 0;

        for (int i=0; i<number.length(); i++) {
            intValue = intValue * 10 + (number.charAt(i) - '0');
        }

        out.println(intValue);
    }
}
