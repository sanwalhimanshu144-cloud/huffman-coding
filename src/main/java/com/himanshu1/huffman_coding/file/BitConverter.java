package com.himanshu1.huffman_coding.file;
import java.io.ByteArrayOutputStream;

public class BitConverter {

    // Bits -> Bytes
    public byte[] bitsToBytes(String bits) {

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int padding = getPadding(bits);

        // Padding add karna
        for (int i = 0; i < padding; i++) {
            bits = bits + "0";
        }

        // 8-8 bits ka group banana
        for (int i = 0; i < bits.length(); i += 8) {

            String byteString = bits.substring(i, i + 8);

            // Binary string ko byte me convert
            int value = Integer.parseInt(byteString, 2);

            output.write(value);
        }

        return output.toByteArray();
    }

    // Bytes -> Bits
    public String bytesToBits(byte[] bytes, int padding) {

        StringBuilder bits = new StringBuilder();

        for (byte b : bytes) {

            String binary = Integer.toBinaryString(b & 255);

            // 8 bit complete karna
            while (binary.length() < 8) {

                binary = "0" + binary;
            }

            bits.append(binary);
        }

        // Padding remove
        return bits.substring(
                0,
                bits.length() - padding);
    }

    public int getPadding(String bits) {

        if (bits.length() % 8 == 0) {

            return 0;
        }

        return 8 - (bits.length() % 8);
    }
}