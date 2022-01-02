package com.example.banking.application;

import java.util.LinkedHashMap;

public class deneme {
	public static void main(String[] args) {
		LinkedHashMap<String, String> lhm
        = new LinkedHashMap<String, String>();

    // Adding entries in Map
    // using put() method
    lhm.put("one", "practice.geeksforgeeks.org");
    lhm.put("one", "code.geeksforgeeks.org");
    lhm.put("one", "quiz.geeksforgeeks.org");

    // Printing all entries inside Map
    System.out.println(lhm);

    // Note: It prints the elements in same order
    // as they were inserted

    // Getting and printing value for a specic key
    System.out.println("Getting value for key 'one': "
                       + lhm.get("one"));

    // Getting size of Map using size() method
    System.out.println("Size of the map: "
                       + lhm.size());

    // Checking whether Map is empty or not
    System.out.println("Is map empty? "
                       + lhm.isEmpty());

    // Using containsKey() method to check for a key
    System.out.println("Contains key 'two'? "
                       + lhm.containsKey("two"));

    // Using containsKey() method to check for a value
    System.out.println(
        "Contains value 'practice.geeks"
        + "forgeeks.org'? "
        + lhm.containsValue("practice"
                            + ".geeksforgeeks.org"));

    // Removing entry using remove() method
    System.out.println("delete element 'one': "
                       + lhm.remove("one"));

    // Printing mappings to the console
    System.out.println("Mappings of LinkedHashMap : "
                       + lhm);
	}
}