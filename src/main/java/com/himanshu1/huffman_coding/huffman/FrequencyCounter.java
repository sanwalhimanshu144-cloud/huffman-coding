package com.himanshu1.huffman_coding.huffman;
import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {

    public Map<Character, Integer> countFrequency(String data) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for(char ch : data.toCharArray()) {
            frequencyMap.put(
                ch,
                frequencyMap.getOrDefault(ch, 0) + 1
            );
        }

        return frequencyMap;
    }
}