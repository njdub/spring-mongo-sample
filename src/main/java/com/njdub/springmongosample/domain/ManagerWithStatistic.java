package com.njdub.springmongosample.domain;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagerWithStatistic {
    @JsonUnwrapped
    private Manager manager;
    private Integer activeTicketsCount;
}
