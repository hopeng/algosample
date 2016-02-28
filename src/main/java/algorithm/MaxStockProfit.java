package algorithm;

/**
 * http://stackoverflow.com/questions/1663545/find-buy-sell-prices-in-array-of-stock-values-to-maximize-positive-difference
 */
public class MaxStockProfit {

    public static void main(String args[]) {
        double[] values = new double[] { 55.39, 109.23, 48.29, 81.59, 81.58, 105.53, 94.45, 12.24 };

        double low = values[0];
        double finalLow = values[0];
        double high = values[1];
        double maxDiff = high - low;

        for (int i=2; i<values.length; i++) {
            double diff = values[i] - low;
            if (diff > maxDiff) {
                // set new high
                maxDiff = diff;
                high = values[i];
                finalLow = low;

            } else if (values[i] < low) {
                // set new low
                low = values[i];
            }
        }

        System.out.printf("diff %s, finalLow %s, top %s, low %s", maxDiff, finalLow, high, low);
    }
}
