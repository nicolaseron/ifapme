package com.example.bank.command;

import lombok.Data;

@Data
public class CreateTransactionBaseCommand {
    private Integer accountId;
    private Integer amount;
}
