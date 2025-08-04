package CollectionsTask14;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Config config = new Config("C:\\Users\\ShivaKumarBantu\\IdeaProjects\\pizzashops\\src\\CollectionsTask14\\config.properties");

        config.set("newkey", "new vlaue");
        config.get("newkey");
        System.out.println(config.get("newkey"));
        config.save();
    }
}