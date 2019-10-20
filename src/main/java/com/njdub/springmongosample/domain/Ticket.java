package com.njdub.springmongosample.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigInteger;
import java.time.Instant;

@Getter
@Setter
@ToString
@Document("tickets")
public class Ticket {

    @Id
    private BigInteger id;

    private String title;
    private String description;
    private TicketStatus status;
    private Instant created;

    @Field(targetType = FieldType.OBJECT_ID)
    private BigInteger managerId;

}
