package com.njdub.springmongosample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Getter
@Setter
@ToString
@Document("managers")
public class Manager {
    @Id
    private BigInteger id;

    @Indexed(unique = true)
    private String email;
    private String firstName;
    private String lastName;
}
