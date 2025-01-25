package com.example.bank.command;

import lombok.Data;

@Data
public class CreateTransactionTransfertCommand extends CreateTransactionBaseCommand {
    private Integer beneficiaryId;
}
