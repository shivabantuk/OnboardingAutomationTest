package CollectionsTask12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SocialNetwork {

    private Map<String, Set<String>> network = new HashMap<>();

    public void addUser(String user) {
        network.putIfAbsent(user, new HashSet<>());
    }

    public void addFriend(String user1, String user2) {
        addUser(user1);
        addUser(user2);
        network.get(user1).add(user2);
        network.get(user2).add(user1);
    }

    public void removeFriend(String user1, String user2) {
        if(network.containsKey(user1)) {
            network.remove(user1);
        }
        if(network.containsKey(user2)) {
            network.remove(user2);
        }
    }
    public void displayTotalFriends(){
        for(String user: network.keySet()){
            System.out.println(user + ": has" + network.get(user).size()+ " friends");
        }
    }

}
