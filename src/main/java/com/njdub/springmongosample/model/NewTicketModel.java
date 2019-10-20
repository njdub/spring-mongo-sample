package com.njdub.springmongosample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class NewTicketModel {

    @NotBlank
    private String title;
    @NotNull
    private String description;
}
