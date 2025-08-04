package CollectionsTask02_Hometask_Comparator;

import java.util.Comparator;

public class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if(a.score != b.score){
            return b.score - a.score;
        }
        else {
            return a.name.compareTo(b.name);
        }
    }
}
