package com.himanshu1.huffman_coding.controller;
import com.himanshu1.huffman_coding.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class HuffmanController {

    @Autowired
    private HuffmanService huffmanService;

    // 1. Compress & Download File
    @PostMapping("/compress")
    public ResponseEntity<byte[]> compressAndDownload(@RequestBody String originalData) {
        try {
            byte[] fileData = huffmanService.compressData(originalData);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", "compressed_data.huf");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            return new ResponseEntity<>(fileData, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 2. Upload File & Decompress
    @PostMapping("/decompress")
    public ResponseEntity<String> uploadAndDecompress(@RequestParam("file") MultipartFile file) {
        try {
            String originalData = huffmanService.decompressData(file);
            return new ResponseEntity<>("Decoded Data: \n" + originalData, HttpStatus.OK);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Error during decompression: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}