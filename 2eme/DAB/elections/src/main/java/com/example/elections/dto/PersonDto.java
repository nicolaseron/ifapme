package com.example.elections.dto;

import com.example.elections.model.Adress;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonDto {
    private String id;
    private String firstname;
    private String lastname;
    private String nationalNumber;
    private AdressDto adress;
}
