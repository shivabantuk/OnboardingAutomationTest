package HomeTask;

public class HomeTaskString1 {
    public static void main(String[] args) {
        String name = "aabcccccaaa";
        StringBuilder result = new StringBuilder();
        int count =1;
        for(int i=0;i<name.length();i++) {

            if (i + 1 < name.length() && name.charAt(i) == name.charAt(i + 1)) {
                count++;

            }
            else  {
                result.append(name.charAt(i)).append(count);
                count = 1;
            }


        }

        System.out.println(result);

    }
}
