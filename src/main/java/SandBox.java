
import java.util.*;

import static java.lang.System.out;

/**
 * Created by hopeng on 20/11/2014.
 */
public class SandBox {

    public static void main(String args[]) {


        ABC<Number> sample = new ABC<Number>();

        SandBox.<Number>addBox(0, new ArrayList<>());

//        sample.<String>findInt("aadc");

        Map<String, Long> sampleMap = new HashMap();

        Box<? extends List> wildcardBox = new Box<>();
        processList(wildcardBox);

        List<?> anyList = new ArrayList<>();
        anyList.add(null);

        Runnable[] arrayOfLists = new Runnable[2];
//        Thread
//        BlockingQueue
    }

    public static void bigVector() {
        BitSet bs = new BitSet();
        bs.set(1000000000);
        bs.set(1000000001);
        out.println(Long.toString(1L << 1, 2));
        out.println(Long.toString(1L << 10, 2));
        out.println(Long.toString(1L << 63, 2));
        out.println(Long.toString(1L << 64, 2));
        out.println(Long.toString(1L << 65, 2));
        out.println(Long.toString(1L << 1000, 2));
        out.println(Long.toString(1L << 10000, 2));
        out.println(Long.toString(1L << 100000, 2));
        out.println(Long.toString(1L << 1000000, 2));
        out.println(Long.toString(1L << 10000000, 2));
        out.println(Long.toString(1L << 1000000000, 2));
        out.println(Long.toString(1L << 1000000001, 2));
    }

    public final static class MyException extends Exception {

    }

    static class ABC<E extends Number> {
        public <T extends List> int findInt(T sample) {
            if (sample instanceof List<?>) {

            }
            return sample.hashCode();
        }

        void m1(List<Number> list) {

        }
    }

    static class DEF extends ABC {

    }

    public static <U> void addBox(U u,
                                  java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static void processList(Box<? extends Collection> list) {

    }
}
