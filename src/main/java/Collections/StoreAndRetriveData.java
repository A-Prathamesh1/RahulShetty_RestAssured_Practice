package Collections;

import java.util.*;

public class StoreAndRetriveData {
    /*
[
  {
    "name": "United States",
    "population": 331002651
  },
  {
    "name": "France",
    "population": 65273511
  }]
   */
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Map<String, String> m1 = new HashMap<>();
        m1.put("name", "US");
        m1.put("population", "331002651");
        Map<String, String> m2 = new HashMap<>();
        m2.put("name", "France");
        m2.put("population", "65273511");




        // OR
        List<Map<String, String>> listOfMaps = new ArrayList<>();
        listOfMaps.add(m1);
        listOfMaps.add(m2);
        System.out.println("get population of france");
        for (Map<String, String> m : listOfMaps) {
            if (m.get("name") == "France") {
                System.out.println(m.get("population"));
            }
        }
    }
}

