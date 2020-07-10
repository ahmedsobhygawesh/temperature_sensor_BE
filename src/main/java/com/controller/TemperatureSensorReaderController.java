package com.controller;

import com.service.DeviceTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemperatureSensorReaderController {

    final String HEX_DECIMAL_REGEX = "^[0][x][0-9A-F]+$";
    @Autowired DeviceTemperatureService deviceTemperatureService;

    @PostMapping("/temperatures")
     void saveTemperatureDegree(@RequestBody String temperatureRecords) throws Exception {
        int tcLength = temperatureRecords.length();
        if (temperatureRecords.matches(HEX_DECIMAL_REGEX) && (temperatureRecords.length() % 2 == 0
         && temperatureRecords.substring(2, tcLength).length() % 10 == 0)) {
            deviceTemperatureService.saveDeviceTemperature(temperatureRecords.substring(2, tcLength));
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
