package com.service.mapper;

import com.model.TemperatureModel;
import com.repository.entity.Temperature;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemperatureMapper {

    TemperatureModel toModel(Temperature temperature);
    Temperature toEntity(TemperatureModel temperature);
}
