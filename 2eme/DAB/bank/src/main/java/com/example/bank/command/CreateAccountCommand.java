package com.example.bank.command;

import lombok.Data;

@Data
public class CreateAccountCommand {
    private String accountNumber;
    private Integer personId;
}
