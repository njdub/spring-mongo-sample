package com.njdub.springmongosample.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ManagerWithStatistic extends Manager {
    private Integer activeTicketsCount;
}
