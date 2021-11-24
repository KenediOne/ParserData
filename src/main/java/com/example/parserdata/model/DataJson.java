package com.example.parserdata.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DataJson {

    private String productUuid;

    private String productName;

    private Long amount;
}
