package HomeTask;

public class HomeTaskString {

    public static void main(String[] args) {
        String name  ="aabcccccaaa";
        char[]  ch = name.toCharArray();
        int vowel = 0;
        int consonants=0;
        for(char c:ch)
        {
            if(c>=97&&c<=122)
            {
                if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                {
                    vowel++;
                }
                else
                {
                    consonants++;
                }
            }


        }
        System.out.println(vowel);
        System.out.println(consonants);

    }


}
