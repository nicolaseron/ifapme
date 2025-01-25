package org.example.car.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.example.car.model.Color;

@Data
@SuperBuilder
public class CarBaseCommand {
    private String plaqueNumber;
    private Color color;
    private Integer userId;
}
