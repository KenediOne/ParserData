package com.example.parserdata;

import com.example.parserdata.controller.DataController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParserDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParserDataApplication.class, args);
        DataController dataController = new DataController();
        dataController.inputDataForJson();
    }

}
