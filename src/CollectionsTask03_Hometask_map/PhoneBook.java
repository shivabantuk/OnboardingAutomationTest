package CollectionsTask03_Hometask_map;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[]  args){
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> phoneBook = new HashMap<String, String>();
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String phone = sc.nextLine();
            phoneBook.put(name, phone);
        }
        while(sc.hasNextLine()){
            String query = sc.nextLine();
            if(phoneBook.containsKey(query)){
                System.out.println(query + " " + phoneBook.get(query));
            }
            else {
                System.out.println("not found");
            }

        }
    }
}
