package com.example.elections.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdressDto {
    private Integer id;
    private String localite;
    private String street;
    private String box;
    private Integer postalCode;
}
