# Huffman Coding

A Spring Boot REST API that implements the Huffman Coding algorithm for lossless text compression and decompression.

## Overview

This project takes text data, builds a Huffman tree based on character frequencies, and encodes the data into a compact binary format. It also supports decoding compressed files back into the original text.

## Features

- Compress text data and download it as a `.huf` file
- Upload a compressed `.huf` file and decompress it back to the original text
- Huffman tree construction based on character frequency
- Custom bit-level encoding for efficient compression

## Tech Stack

- **Java 21**
- **Spring Boot** (Web MVC)
- **Maven** (build tool)
- **Lombok**

## Project Structure

```
src/main/java/com/himanshu1/huffman_coding/
├── controller/
│   └── HuffmanController.java     # REST endpoints
├── service/
│   └── HuffmanService.java        # Compression/decompression logic
├── huffman/
│   ├── HuffmanTree.java           # Huffman tree construction
│   ├── HuffmanEncoder.java        # Encoding logic
│   ├── HuffmanDecoder.java        # Decoding logic
│   ├── HuffmanNode.java           # Tree node representation
│   └── FrequencyCounter.java      # Character frequency counting
└── file/
    ├── CompressedData.java        # Compressed data model
    └── BitConverter.java          # Bit-level utilities
```

## API Endpoints

### 1. Compress Data
```
POST /api/compress
```
**Body:** Raw text (String)
**Response:** Downloads a compressed `.huf` file

### 2. Decompress File
```
POST /api/decompress
```
**Body:** `multipart/form-data` with a `.huf` file under the `file` field
**Response:** The original decoded text

## How to Run

1. Clone the repository
   ```bash
   git clone https://github.com/sanwalhimanshu144-cloud/huffman-coding.git
   cd huffman-coding
   ```

2. Build the project
   ```bash
   ./mvnw clean install
   ```

3. Run the application
   ```bash
   ./mvnw spring-boot:run
   ```

4. The API will be available at `http://localhost:8080`

## Testing the API

Using `curl` to compress:
```bash
curl -X POST http://localhost:8080/api/compress -d "your text here" -o compressed_data.huf
```

Using `curl` to decompress:
```bash
curl -X POST http://localhost:8080/api/decompress -F "file=@compressed_data.huf"
```

## License

This project is open source and available for personal or educational use.
