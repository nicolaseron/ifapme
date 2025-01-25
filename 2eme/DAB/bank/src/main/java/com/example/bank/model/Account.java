package com.example.bank.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('account_id_seq'")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "account_number", nullable = false, length = Integer.MAX_VALUE)
    private String accountNumber;

    @Column(name = "balance", nullable = false)
    private Integer balance = 0;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_person", nullable = false)
    private Person idPerson;


    public Account(String accountNumber, Person idPerson) {
        this.accountNumber = accountNumber;
        this.idPerson = idPerson;
    }
}