package com.util;

import com.model.DeviceModel;
import com.model.TemperatureModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HexConverter {

    /*
    final static int DEVICE_TEMP_MAX_LENGTH = 10, DEVICE_LENGTH = 8, TEMPERATURE_LENGTH = 2;

    public static List<DeviceModel> convertHexToDecimal(String sensorHexValues) {
        int counter = 1, initial = 0, loopTimes = sensorHexValues.length() / DEVICE_TEMP_MAX_LENGTH;
        List<String> deviceWithItsTemperature = new ArrayList<>();
        List<DeviceModel> devices = new ArrayList<>();

        do {
            deviceWithItsTemperature.add(sensorHexValues.substring(initial, DEVICE_TEMP_MAX_LENGTH * counter));
            initial = counter * DEVICE_TEMP_MAX_LENGTH;
            counter++;
        }
        while (counter <= loopTimes);

        deviceWithItsTemperature.forEach(dt -> {
            DeviceModel device = new DeviceModel();
            TemperatureModel temp = new TemperatureModel();
            List<TemperatureModel> temperatures = new ArrayList<>();

            device.setId((long) Integer.parseInt(dt.substring(0, DEVICE_LENGTH - 1)));
            temp.setId((long) Integer.parseInt(dt.substring(DEVICE_LENGTH, DEVICE_LENGTH + TEMPERATURE_LENGTH)));
            temp.setReceivedDate(LocalDateTime.now());

            temperatures.add(temp);
            device.setTemperatures(temperatures);

            devices.add(device);
        });
        return devices;
    }
    */

}