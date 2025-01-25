package com.example.bank.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('transaction_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = Integer.MAX_VALUE)
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate = LocalDate.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_account", nullable = false)
    private Account idAccount;

    @ManyToOne
    @JoinColumn(name = "beneficiary_account")
    private Account beneficiaryAccount;

    public Transaction(TransactionType type, Integer amount, Account idAccount, Account beneficiaryAccount) {
        this.type = type;
        this.amount = amount;
        this.idAccount = idAccount;
        this.beneficiaryAccount = beneficiaryAccount;
    }

}