package com.service.impl;

import com.model.DeviceModel;
import com.model.MixDeviceWithTemperatureModel;
import com.model.TemperatureModel;
import com.repository.DeviceRepository;
import com.repository.TemperatureRepository;
import com.repository.entity.Device;
import com.repository.entity.Temperature;
import com.service.DeviceTemperatureService;
import com.service.mapper.DeviceMapper;
import com.service.mapper.TemperatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceTemperatureServiceImpl implements DeviceTemperatureService {

    @Value("${sensorTemperature.deviceLength}")
    private int deviceLength;

    @Value("${sensorTemperature.deviceTempLength}")
    private int deviceTempLength;

    @Value("${sensorTemperature.tempLength}")
    private int tempLength;

    @Autowired DeviceRepository deviceRepository;
    @Autowired TemperatureRepository temperatureRepository;
    @Autowired DeviceMapper deviceMapper;
    @Autowired TemperatureMapper temperatureMapper;

    @Override
    public void saveDeviceTemperature(String devicesTemp) {
        List<MixDeviceWithTemperatureModel> mixRetrievedList = convertHexToDecimalForDevicesWithTemperature(devicesTemp);

        mixRetrievedList.forEach(mixObj -> {
            Device savedDevice = deviceRepository.save(deviceMapper.toEntity(mixObj.getDeviceM()));
            Temperature t = temperatureMapper.toEntity(mixObj.getTemperatureM());
            t.setDevice(savedDevice);
            temperatureRepository.save(t);
        });
    }

    @Override
    public List<DeviceModel> findLatestTemperature() {
        return deviceRepository.findAll().stream()
                .map(device -> deviceMapper.toModel(device))
                .collect(Collectors.toList());
    }

    @Override
    public List<DeviceModel> findDeviceTemperatures(long deviceId) {
        return deviceRepository.findDevicesAllById(deviceId).stream()
                .map(device -> deviceMapper.toModel(device))
                .collect(Collectors.toList());
    }

    private List<MixDeviceWithTemperatureModel> convertHexToDecimalForDevicesWithTemperature(String sensorHexValues) {
        int counter = 1, initial = 0, loopTimes = sensorHexValues.length() / deviceTempLength;
        List<String> separatedDevicesAndTemperatures = new ArrayList<>();
        List<MixDeviceWithTemperatureModel> mixDAndTList = new ArrayList<>();

        do {
            separatedDevicesAndTemperatures.add(sensorHexValues.substring(initial, deviceTempLength * counter));
            initial = counter * deviceTempLength;
            counter++;
        }
        while (counter <= loopTimes);

        separatedDevicesAndTemperatures.forEach(dt -> {
            MixDeviceWithTemperatureModel mixDTObj = new MixDeviceWithTemperatureModel();

            mixDTObj.setDeviceM(new DeviceModel());
            mixDTObj.setTemperatureM(new TemperatureModel());

            try {
                mixDTObj.getDeviceM().setId(Long.parseLong(dt.substring(0, deviceLength), 16));
                mixDTObj.getTemperatureM().setDegree(Short.parseShort(dt.substring(deviceLength, deviceLength + tempLength), 16));
                mixDTObj.getTemperatureM().setReceivedDate(LocalDateTime.now());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            mixDAndTList.add(mixDTObj);
        });
        return mixDAndTList;
    }


}
