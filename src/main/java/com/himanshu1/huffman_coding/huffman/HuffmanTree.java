package com.himanshu1.huffman_coding.huffman;

import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {

    public HuffmanNode buildTree(Map<Character, Integer> frequencyMap) {

        // Min Heap
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(
                (a, b) -> a.frequency - b.frequency);

        // Frequency map se nodes banana
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {

            HuffmanNode node = new HuffmanNode(
                    entry.getKey(),
                    entry.getValue());

            queue.add(node);
        }

        // Tree banana
        while (queue.size() > 1) {

            // Sabse chhoti frequency wale 2 nodes
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();

            // Naya parent node
            HuffmanNode parent = new HuffmanNode(
                    left.frequency + right.frequency,
                    left,
                    right);

            // Wapas heap me daalna
            queue.add(parent);
        }

        // Final root
        return queue.poll();
    }
}