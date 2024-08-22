package com.example.csv_data.controller;

import com.example.csv_data.service.MyService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/data")
public class MyController {

    @Autowired
    MyService myService;

    @PostMapping()
    public ResponseEntity<String> addData(@RequestParam("file") MultipartFile file)
    {
        return myService.addData(file);
    }


}
