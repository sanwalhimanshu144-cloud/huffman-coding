package com.himanshu1.huffman_coding.huffman;

public class HuffmanDecoder {


    public String decode(String encodedData, HuffmanNode root) {

        StringBuilder result = new StringBuilder();

        HuffmanNode current = root;


        for(char bit : encodedData.toCharArray()) {


            if(bit == '0') {
                current = current.left;
            }
            else {
                current = current.right;
            }


            // Leaf node mil gaya
            if(current.left == null && current.right == null) {

                result.append(current.ch);

                // wapas root pe aana
                current = root;
            }
        }


        return result.toString();
    }
}