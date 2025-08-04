package CollectionsTask12;

public class Main {
    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addFriend("Alice", "Bob");
        socialNetwork.addFriend("Bob", "Charlie");

        socialNetwork.displayTotalFriends();
    }
}
