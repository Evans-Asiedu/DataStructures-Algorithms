package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public Character firstRepeatedChar(String str){
        Set<Character> sets = new HashSet<>();
        for(char ch: str.toCharArray()){
            if(sets.contains(ch))
                return ch;
            sets.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public Character firstRepeatedChar2(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: str.toCharArray()){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for(char ch: str.toCharArray()){
           if(map.get(ch) > 1)
               return ch;
        }
       return Character.MIN_VALUE;
    }
}
