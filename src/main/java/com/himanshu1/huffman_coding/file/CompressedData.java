package com.himanshu1.huffman_coding.file;
import java.io.Serializable;
import java.util.Map;

public class CompressedData implements Serializable {
    
    // Serialization ke liye ye ID zaroori hoti hai, taaki version mismatch na ho
    private static final long serialVersionUID = 1L; 
    
    public byte[] compressedBytes;
    public int padding;
    public Map<Character, Integer> frequencyMap;

    // Constructor data set karne ke liye
    public CompressedData(byte[] compressedBytes, int padding, Map<Character, Integer> frequencyMap) {
        this.compressedBytes = compressedBytes;
        this.padding = padding;
        this.frequencyMap = frequencyMap;
    }
}