package com.example.parserdata.request;

import com.example.parserdata.model.DataJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RestTemplateImpl implements RestTemplate {

    private final WebClient client;

    @Autowired
    public RestTemplateImpl(String urlAddress ) {
        this.client = WebClient.create( urlAddress );
    }

    @Override
    public List<DataJson> getDataJson() throws RuntimeException {
        return Arrays.asList(
                Objects.requireNonNull(client
                        .get()
                        .retrieve()
                        .onStatus(HttpStatus::isError, error -> Mono.error(new RuntimeException("API not found")))
                        .bodyToMono(DataJson[].class)
                        .block()));
    }
}
