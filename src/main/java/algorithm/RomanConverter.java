package algorithm;

import java.util.*;

import static java.lang.System.*;

public class RomanConverter {
    private static Map<Integer, String> map = new HashMap<Integer, String>();
    private static Set<Integer> BASES;
    
    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        
        BASES = new TreeSet<>(Comparator.<Integer>naturalOrder().reversed());
        BASES.addAll(map.keySet());
    }

    public static String convert(int number) {
        String result = "";
        for (int base : BASES) {
            while (number >= base) {
                number -= base;
                result += map.get(base);
            }
        }

        return result;
    }

    public static void main(String args[]) {
        out.println(convert(1));
        out.println(convert(2));
        out.println(convert(3));
        out.println(convert(4));
        out.println(convert(5));
        out.println(convert(6));
        out.println(convert(7));
        out.println(convert(8));
        out.println(convert(9));
        out.println(convert(10));
        out.println(convert(11));
        out.println(convert(13));
        out.println(convert(20));
        out.println(convert(200));
        out.println(convert(12333));
    }
}
