package com.service.mapper;

import com.model.DeviceModel;
import com.repository.entity.Device;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TemperatureMapper.class)
public interface DeviceMapper {

    DeviceModel toModel(Device device);
    Device toEntity(DeviceModel device);

}
