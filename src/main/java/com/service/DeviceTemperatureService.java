package com.service;

import com.model.DeviceModel;
import java.util.List;

public interface DeviceTemperatureService {

    void saveDeviceTemperature(String devicesTemp);
    List<DeviceModel> findLatestTemperature();
    List<DeviceModel> findDeviceTemperatures(long deviceId);
}
