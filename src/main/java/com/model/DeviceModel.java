package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class DeviceModel {

    private Long id;
    private String name;
    private String model;
    private List<TemperatureModel> temperatures = new ArrayList<>();

}
