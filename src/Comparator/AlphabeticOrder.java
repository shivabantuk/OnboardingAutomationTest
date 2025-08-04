package Comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphabeticOrder {

        public static void main(String[] args) {
          List<String> names = Arrays.asList("Shiva","Kumar","Bantu");
          Collections.sort(names, new Comparator<String>() {
              @Override
              public int compare(String a, String b) {
                  return a.compareTo(b);
              }
          });
          System.out.println(names);

        }

    }


