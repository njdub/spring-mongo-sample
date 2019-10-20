package com.njdub.springmongosample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@ToString
public class AssignTicketModel {

    @NotNull
    private BigInteger managerId;
}
