package com.example.csv_data.service;

import com.example.csv_data.model.Model;
import com.example.csv_data.repository.MyRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

    @Autowired
    MyRepository myRepository;

    public ResponseEntity<String> addData(MultipartFile file) {
        List<Model> records=new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(),"UTF-8"));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder()
                     .setHeader() // Automatically detects and uses the first row as the header
                     .setIgnoreHeaderCase(true) // Case-insensitive header matching
                     .setTrim(true) // Trims leading/trailing whitespaces in fields
                     .setSkipHeaderRecord(true) // Skip the header row when iterating records
                     .build())) {

            for (CSVRecord csvRecord : csvParser) {
                Model model = new Model();
                model.setName(csvRecord.get("Name"));
                model.setEmail(csvRecord.get("Email"));
                model.setDestination(csvRecord.get("Destination"));

                records.add(model);
            }

            myRepository.saveAll(records);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Data Saved to Database", HttpStatus.OK);
    }
}
