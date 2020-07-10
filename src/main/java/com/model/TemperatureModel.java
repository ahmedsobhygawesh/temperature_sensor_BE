package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class TemperatureModel {

    private Long id;
    private short degree;
    private LocalDateTime receivedDate;

}
