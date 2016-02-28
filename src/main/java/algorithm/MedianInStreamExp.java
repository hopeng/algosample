package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by hopeng on 30/12/2015.
 */
public class MedianInStreamExp {

    private PriorityQueue<Integer> aboveMedianHeap = new PriorityQueue<>();

        Comparator<Integer> reversedComparator = (o1, o2) -> o2.compareTo(o1);
//    Comparator<Integer> reversedComparator = Comparator.<Integer>naturalOrder().reversed();
    private PriorityQueue<Integer> belowMedianHeap = new PriorityQueue<>(reversedComparator);


    public static void main(String args[]) {

        MedianInStreamExp instance = new MedianInStreamExp();
        System.out.println(instance.getMedian());

        int[] stream = new int[] {4,6,2,44,1,33,5,7,6,9};
        for (int n : stream) {
            instance.addNumber(n);
            System.out.println(instance.getMedian());
        }
    }

    public void addNumber(int number) {
        if (belowMedianHeap.size() == aboveMedianHeap.size()) {
            if (aboveMedianHeap.peek() != null && number > aboveMedianHeap.peek()) {
                belowMedianHeap.offer(aboveMedianHeap.poll());
                aboveMedianHeap.offer(number);
            } else {
                belowMedianHeap.offer(number);
            }

        } else {
            if (number < belowMedianHeap.peek()) {
                aboveMedianHeap.offer(belowMedianHeap.poll());
                belowMedianHeap.offer(number);
            } else {
                aboveMedianHeap.offer(number);
            }
        }
    }

    public Integer getMedian() {
        if (belowMedianHeap.isEmpty())
            return aboveMedianHeap.peek();
        else if (aboveMedianHeap.isEmpty())
            return belowMedianHeap.peek();

        if (belowMedianHeap.size() == aboveMedianHeap.size()) {
            return (aboveMedianHeap.peek() + belowMedianHeap.peek()) / 2;

        } else if (belowMedianHeap.size() > aboveMedianHeap.size()) {
            return belowMedianHeap.peek();
        } else {
            return aboveMedianHeap.peek();
        }
    }
}
