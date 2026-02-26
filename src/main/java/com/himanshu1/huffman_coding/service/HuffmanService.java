package com.himanshu1.huffman_coding.service; // Sirf ye ek package line honi chahiye

// Ye import sabse zaroori hai! Isse huffman folder ki saari files yahan access ho jayengi
import com.himanshu1.huffman_coding.huffman.*; 

import com.himanshu1.huffman_coding.file.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

@Service
public class HuffmanService {

    public byte[] compressData(String originalData) throws Exception {
        // 1. Frequency Count & Tree Build
        FrequencyCounter counter = new FrequencyCounter();
        Map<Character, Integer> freqMap = counter.countFrequency(originalData);

        HuffmanTree treeBuilder = new HuffmanTree();
        HuffmanNode root = treeBuilder.buildTree(freqMap);

        // 2. Generate Codes & Encode
        HuffmanEncoder encoder = new HuffmanEncoder();
        Map<Character, String> codes = encoder.generateCodes(root);
        String bitString = encoder.encode(originalData, codes);

        // 3. Bits to Bytes
        BitConverter bitConverter = new BitConverter();
        byte[] bytes = bitConverter.bitsToBytes(bitString);
        int padding = bitConverter.getPadding(bitString);

        // 4. Create Object & Serialize to byte array
        CompressedData dataToSave = new CompressedData(bytes, padding, freqMap);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(dataToSave);
        oos.flush();
        
        return bos.toByteArray();
    }

    public String decompressData(MultipartFile file) throws Exception {
        // 1. Read uploaded file & Deserialize
        ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
        ObjectInputStream ois = new ObjectInputStream(bis);
        CompressedData savedData = (CompressedData) ois.readObject();
        ois.close();

        // 2. Bytes back to Bits
        BitConverter bitConverter = new BitConverter();
        String bitString = bitConverter.bytesToBits(savedData.compressedBytes, savedData.padding);

        // 3. Rebuild Tree
        HuffmanTree treeBuilder = new HuffmanTree();
        HuffmanNode root = treeBuilder.buildTree(savedData.frequencyMap);

        // 4. Decode Bits
        HuffmanDecoder decoder = new HuffmanDecoder();
        return decoder.decode(bitString, root);
    }
}