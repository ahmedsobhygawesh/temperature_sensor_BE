package com.controller;

import com.service.DeviceTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TemperatureSensorReaderController {

    final String HEX_DECIMAL_REGEX = "^[0][x][0-9A-F]+$";
    @Autowired DeviceTemperatureService deviceTemperatureService;

    @PostMapping("/temperatures")
     void saveTemperatureDegree(@RequestBody String temperatureCollection) throws Exception {
        if (temperatureCollection.matches(HEX_DECIMAL_REGEX) && (temperatureCollection.length() % 2 == 0
         && temperatureCollection.substring(2, temperatureCollection.length()).length() % 10 == 0)) {
            deviceTemperatureService.saveDeviceTemperature(temperatureCollection.substring(2, temperatureCollection.length()));
        } else {
            throw new Exception("Invalid Pattern");
        }
    }

    @GetMapping("/temperatures")
    void findLatestTemperatures() {
        deviceTemperatureService.findLatestTemperature();
    }

    @GetMapping("temperatures/devices/{deviceId}")
    void findLatestTemperatures(@PathVariable short deviceId) {
        deviceTemperatureService.findDeviceTemperatures(deviceId);
    }

}
