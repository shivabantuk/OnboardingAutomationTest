package TreeMap;

import java.util.*;

public class ValuesInDecendingOrder {
    public static void main(String[] args) {
        TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext())
        {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
            System.out.println(entry.getValue()+ " "+ entry.getKey() );
        }

     }
}
