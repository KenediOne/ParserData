package com.example.parserdata.controller;

import com.example.parserdata.model.DataJson;
import com.example.parserdata.request.RestTemplate;
import com.example.parserdata.request.RestTemplateImpl;
import com.example.parserdata.service.DataService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController
public class DataController {

    private DataService dataService = new DataService();
    private RestTemplate restTemplate;

    @GetMapping(value = "/api/data",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DataJson> getPath(
            @RequestParam("path")String path
    ){
        List<DataJson> dataJsons = getData(path);
        System.out.println(dataService.getJson(dataJsons));
        return dataJsons;
    }

    public void inputDataForJson(){
        int count = 0;
        while (count < 20){
            System.out.println(dataService.getJson(input()));
            count++;
        }
    }

    private List<DataJson> input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the file: ");
        return getData(scanner.nextLine());
    }

    private List<DataJson> getData(String path){
        List<DataJson> dataJsons = new ArrayList<>();
        if(path.contains("http")){
            restTemplate = new RestTemplateImpl(path);
            dataJsons = restTemplate.getDataJson();
        }else {
            try {
                dataJsons = dataService.getData(path);
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(dataJsons.size());
        return dataJsons;
    }
}
