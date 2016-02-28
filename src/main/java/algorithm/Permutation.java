package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

public class Permutation {

    public static void main(String args[]) {
        String target = "abcd";

        // solution 1
        List<String> result = permute(target);
        out.println("result size is " + result.size());
        for (String s : result) {
            out.println(s);
        }
        // solution 2
        out.println(Arrays.toString(permuteExp(target)));
    }

    public static void permute(String prefix, String input, List<String> result) {
        if (input.length() == 0) {
            result.add(prefix);

        } else {
            for (int i=0; i<input.length(); i++) {
                String subString = input.substring(0, i) + input.substring(i+1, input.length());
                permute(prefix + input.charAt(i), subString, result);
            }
        }
    }

    public static List<String> permute(String input) {
        int resultSize = 1;
        for (int i=1; i<=input.length(); i++) {
            resultSize *= i;
        }
        List<String> result = new ArrayList<>(resultSize);
        permute("", input, result);
        if (resultSize != result.size()) {
            throw new AssertionError("unexpected result size " + result.size());
        }
        return result;
    }


//    public static void permute(char[] prefix, char[] array, List<String> result) {
//        if (array.length == 0) {
//            result.add(new String(prefix));
//
//        } else {
//            for (int i=0; i<array.length; i++) {
//                char temp = array[i];
//                array[i] = array[0];
//                array[0] = temp;
//                char[] newPrefix = new char[prefix.length + 1];
//                System.arraycopy(prefix, 0, newPrefix, 0, prefix.length);
//                newPrefix[newPrefix.length-1] = array[0];
//                permute(newPrefix, Arrays.copyOfRange(array, 1, array.length), result);
//            }
//        }
//    }

    /**
     * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/#comment-2431551237
     */
    public static String[] permuteExp(String input) {
        if (input.length() == 0) {
            String[] output = {""};
            return output;
        }
        String[] smallerOutput = permuteExp(input.substring(1));
        String[] output = new String[input.length() * ((smallerOutput.length == 0) ? 1 : smallerOutput.length)];
        int i = 0;
        for (String s : smallerOutput) {
            for (int j = 0; j <= s.length(); j++) {
                output[i] = s.substring(0, j) + input.charAt(0) + s.substring(j, s.length());
                i++;
            }
        }
        return output;
    }
}
