package com.example.parserdata.request;

import com.example.parserdata.model.DataJson;

import java.util.List;

public interface RestTemplate {

    List<DataJson> getDataJson();

}
