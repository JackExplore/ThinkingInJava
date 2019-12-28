package alpha.ch11;

import java.util.*;

/**
 * 统计数字出现的次数
 */
public class Statistics {

    public static void main(String[] args) {

        Random rand = new Random(47);

        Map<Integer, Integer> m = new HashMap<Integer, Integer> ();

        for(int i = 0; i < 10000; i++){
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }

        System.out.println(m);

        System.out.println(m.keySet());
        System.out.println(m.entrySet());
        System.out.println(m.values());

//        Collection<Integer> collection = new AbstractCollection<Integer>();

    }
}
