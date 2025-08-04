package Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Collections01_Hometask_ArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        ArrayList<ArrayList<Integer>> names = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(sc.nextInt());
            }
            names.add(line);

            }
        int q =  sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x>=1 && x<=n) {
                ArrayList<Integer> line = names.get(x-1);
                if(y>=1 && y<=line.size()){
                    System.out.println(line.get(y-1));

                }
                else{
                    System.out.println("ERROR");

                }
            }
            else{
                System.out.println("ERROR");


            }
        }
    }
}
