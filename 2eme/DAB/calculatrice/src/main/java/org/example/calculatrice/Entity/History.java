package org.example.calculatrice.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class History {
    private String operation;
    private Double result;

    @Override
    public String toString() {
        return operation + " = "  + result;
    }
}
