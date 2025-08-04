package CollectionsTask02_Hometask_Comparator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            String name = input.next();
            int score = input.nextInt();
            players[i] = new Player(name, score);
        }
        for(Player player : players){
            System.out.println(player.name+ " "  + player.score);
        }
    }
}
