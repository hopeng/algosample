package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hopeng on 30/12/2015.
 */
public class MedianInStream {

    private PriorityQueue<Integer> aboveMedianHeap = new PriorityQueue<>();

        Comparator<Integer> reversedComparator = (o1, o2) -> o2.compareTo(o1);
//    Comparator<Integer> reversedComparator = Comparator.<Integer>naturalOrder().reversed();
    private PriorityQueue<Integer> belowMedianHeap = new PriorityQueue<>(reversedComparator);

    public static void main(String args[]) {
//        Runnable r = () -> System.out.println("aa");
//        Callable<String> c = () -> "aa";

        MedianInStream instance = new MedianInStream();
        System.out.println(instance.getMedian());

        int[] stream = new int[] {4,6,2,44,1,33,5,7,6,9};
        for (int n : stream) {
            instance.addNumber(n);
            System.out.println(instance.getMedian());
        }
    }

    public void addNumber(int number) {
        Integer median = getMedian();

        if (median == null) {
            belowMedianHeap.offer(number);

        } else if (median < number) {
            if (aboveMedianHeap.size() == belowMedianHeap.size()) {
                belowMedianHeap.offer(aboveMedianHeap.poll());
            }
            aboveMedianHeap.offer(number);

        } else {
            if (aboveMedianHeap.size() + 1 == belowMedianHeap.size()) {
                aboveMedianHeap.offer(belowMedianHeap.poll());
            }
            belowMedianHeap.offer(number);
        }
    }

    public Integer getMedian() {
        if (belowMedianHeap.peek() == null) {
            return null;

        } else if (belowMedianHeap.size() == aboveMedianHeap.size()) {
            return (aboveMedianHeap.peek() + belowMedianHeap.peek()) / 2;

        } else {
            return belowMedianHeap.peek();
        }
    }
}
