package org.example.car.command;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CreateCarCommand extends CarBaseCommand {
    private Integer modelId;
}

