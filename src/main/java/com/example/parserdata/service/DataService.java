package com.example.parserdata.service;

import com.example.parserdata.model.DataJson;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<DataJson> getData(String nameFile){
        File fileReader = new File(nameFile);
        if(fileReader.isFile()) {
            try {
                return Arrays.asList(objectMapper.readValue(fileReader, DataJson[].class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new RuntimeException("File not found!");
        }
        return null;
    }

    public String getJson(List<DataJson> jsons){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            objectMapper.writeValue(out,jsons);
            return new String(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
