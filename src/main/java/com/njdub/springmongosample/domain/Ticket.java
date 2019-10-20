package com.njdub.springmongosample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@Document("tickets")
public class Ticket {

    @Id
    private BigInteger id;

    private String title;
    private String description;

}
