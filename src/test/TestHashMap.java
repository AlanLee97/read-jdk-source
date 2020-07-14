package test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map hashmap = new HashMap();
        hashmap.put("one", "AlanLee1");
        hashmap.put("two", "AlanLee2");
        hashmap.put("three", "AlanLee3");


        Object one = hashmap.get("one");
        System.out.println(one);
    }
}
