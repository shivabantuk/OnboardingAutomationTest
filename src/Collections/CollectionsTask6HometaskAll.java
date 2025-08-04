package Collections;

import java.util.*;

public class CollectionsTask6HometaskAll {
    public static void main(String[] args) {
        //ArrayList
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.println(list);

        //LinkedList
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        System.out.println(linkedList);

        //HashMap
        HashMap<String, Integer> HM = new HashMap<>();
        HM.put("a", 1);
        HM.put("b", 2);
        HM.put("c", 3);
        System.out.println(HM);

        //LinkedHashMap
        LinkedHashMap<String, Integer> LinkedHashMap = new LinkedHashMap<>();
        LinkedHashMap.put("a", 1);
        LinkedHashMap.put("b", 2);
        LinkedHashMap.put("c", 3);
        System.out.println(LinkedHashMap);

        //HashSet
        HashSet<String> HS = new HashSet<>();
        HS.add("a");
        HS.add("b");
        HS.add("c");
        System.out.println(HS);
        //LinkedHashSet
        LinkedHashSet<String> LinkedHashSet = new LinkedHashSet<>();
        LinkedHashSet.add("a");
        LinkedHashSet.add("b");
        LinkedHashSet.add("c");
        System.out.println(LinkedHashSet);
        //TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("c");
        System.out.println(treeSet);
        //TreeMap
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "a");
        treeMap.put("b", "b");
        treeMap.put("c", "c");
        System.out.println(treeMap);
    }
}
