package Collections;

import java.util.Scanner;
import java.util.TreeMap;

public class CollectionsTask05_Hometask_TreeMap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =  sc.nextInt();
        while (T-- > 0) {

            int Q = sc.nextInt();
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int i = 0; i < Q; i++) {
                String op = sc.next();
                if(op.equals("a")){
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    map.put(x, y);

                }
                else if(op.equals("b")){
                    int x = sc.nextInt();
                    System.out.print(map.getOrDefault(x, -1));

                }
                else if(op.equals("c")){
                    System.out.print(map.size()+ " ");
                }
                else if(op.equals("d")){
                    int x = sc.nextInt();
                    map.remove(x);
                }
                else if(op.equals("e")){
                    for(int k: map.keySet() ) {
                        System.out.print(k + " " );
                    }
                }
                System.out.print(" ");
            }
        }
    }
}
