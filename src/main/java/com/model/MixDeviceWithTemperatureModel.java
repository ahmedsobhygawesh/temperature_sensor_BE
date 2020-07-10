package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MixDeviceWithTemperatureModel {

    private DeviceModel deviceM;
    private TemperatureModel temperatureM;

}
