package com.example.elections.command;

import lombok.Data;

@Data
public class CreatePersonCommand {
    private String firstName;
    private String lastName;
    private String nationalNumber;
    private Integer adresseId;
}
