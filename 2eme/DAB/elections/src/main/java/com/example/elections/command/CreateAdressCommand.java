package com.example.elections.command;

import lombok.Data;

@Data
public class CreateAdressCommand {
    private String localite;
    private String street;
    private String box;
    private Integer postalCode;
}
