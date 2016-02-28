package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedArraysIntersection {

    public static void main(String args[]) {
        int[] a1 = new int[]{1,2,3,4,6,8,22,40,100};
        int[] a2 = new int[]{3,4,8,9,10,11,22,30,40,100,200,300};
        List<Integer> result = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < a1.length && p2 < a2.length) {
            if (a1[p1] == a2[p2]) {
                result.add(a1[p1]);
                p1++;
                p2++;
            } else if (a1[p1] < a2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        System.out.println(result);
    }

    // todo binary search solution when a2 is big array
}
