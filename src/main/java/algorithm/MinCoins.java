package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCoins {

    public static void main(String args[]) {
        int[] coins = new int[]{1, 3, 9, 10};
        int total = 20;
        int[] counts = new int[total + 1];
        List<Integer>[] minChanges = new List[total+1];
        minChanges[0] = new ArrayList<>();

        for (int i=1; i<= total; i++) {
            counts[i] = Integer.MAX_VALUE;
            int nextCoin = 0;
            for (int coin : coins) {
                if (i >= coin) {
                    if (counts[i] > counts[i - coin] + 1) {
                        counts[i] = counts[i - coin] + 1;
                        nextCoin = coin;
                    }
                }
            }
            minChanges[i] = new ArrayList<>(minChanges[i-nextCoin]);
            minChanges[i].add(nextCoin);
        }

        System.out.println(Arrays.toString(counts));
        System.out.println(Arrays.toString(minChanges));
    }
}
