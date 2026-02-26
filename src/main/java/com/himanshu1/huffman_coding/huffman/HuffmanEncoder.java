package com.himanshu1.huffman_coding.huffman;
import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {

    private Map<Character, String> codes = new HashMap<>();


    // Tree traverse karke codes banana
    public Map<Character, String> generateCodes(HuffmanNode root) {

        generateCodesRecursive(root, "");

        return codes;
    }


    private void generateCodesRecursive(HuffmanNode node, String code) {

        if(node == null) {
            return;
        }


        // Leaf node mila matlab character mil gaya
        if(node.left == null && node.right == null) {
            codes.put(node.ch, code);
            return;
        }


        // Left = 0
        generateCodesRecursive(node.left, code + "0");


        // Right = 1
        generateCodesRecursive(node.right, code + "1");
    }



    // Original data ko compress karna
    public String encode(String data, Map<Character,String> codes) {

        StringBuilder result = new StringBuilder();

        for(char ch : data.toCharArray()) {

            result.append(codes.get(ch));

        }

        return result.toString();
    }
}