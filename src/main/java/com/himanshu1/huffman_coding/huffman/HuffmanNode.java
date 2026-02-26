package com.himanshu1.huffman_coding.huffman;

public class HuffmanNode {

    char ch;
    int frequency;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }

    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }
}