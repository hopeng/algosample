package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeArrays {

    public static void main(String args[]) {
        int[] a1 = new int[]{3,4,9,11,20};
        int[] a2 = new int[]{5,6,7,11, 33,40};
        List<Integer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;

        while (i1 < a1.length && i2 < a2.length) {
            if (a1[i1] < a2[i2]) {
                result.add(a1[i1]);
                i1++;

            } else {
                result.add(a2[i2]);
                i2++;
            }
        }

        for (int i=i1; i < a1.length; i++) {
            result.add(a1[i]);
        }

        for (int i=i2; i < a2.length; i++) {
            result.add(a2[i]);
        }

        System.out.println(result);
    }
}
