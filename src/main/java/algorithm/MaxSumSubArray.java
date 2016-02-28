package algorithm;


import static java.lang.System.out;

public class MaxSumSubArray {

    public static void main(String args[]) {
        int[] array = new int[] {-2,1, -3, 4, -1, 2, 1, -5, 4};

        int begin = 0, end = 0, newBegin = 0;
        int sum = array[begin];
        int maxSum = sum;
        for (int i=1; i<array.length; i++) {
            if (sum < 0) {
                newBegin = i;
                sum = 0;
            }

            sum += array[i];
            if (sum > maxSum) {
                begin = newBegin;
                end = i;
                maxSum = sum;
            }
        }

        out.printf("maxSum %d, begin %d, end %d, newBegin %d", maxSum, begin, end, newBegin);
    }
}
