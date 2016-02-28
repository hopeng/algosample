package algorithm;

import java.util.BitSet;

import static java.lang.System.out;

public class RotateSentence {

    public static void main(String args[]) {


        String sentence = "  Student are  you boss your am   I   ";
        char[] chars = sentence.toCharArray();
        StringBuilder result = new StringBuilder();

        int wordStart = sentence.length();
        int wordEnd = sentence.length();

        while (wordStart > 0) {
            wordStart--;
            if (wordStart == 0) {
                result.append(sentence.substring(wordStart, wordEnd));

            } else if (chars[wordStart] == ' ') {
                result.append(sentence.substring(wordStart+1, wordEnd)).append(' ');
                wordEnd = wordStart;
            }
        }

        out.println("'" + result + "'");

        // todo standard solution, rotate words and then rotate whole sentence
    }
}
