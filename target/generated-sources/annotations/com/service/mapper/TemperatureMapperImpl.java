package com.service.mapper;

import com.model.TemperatureModel;
import com.repository.entity.Temperature;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-10T15:14:14+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class TemperatureMapperImpl implements TemperatureMapper {

    @Override
    public TemperatureModel toModel(Temperature temperature) {
        if ( temperature == null ) {
            return null;
        }

        TemperatureModel temperatureModel = new TemperatureModel();

        temperatureModel.setId( temperature.getId() );
        temperatureModel.setDegree( temperature.getDegree() );
        temperatureModel.setReceivedDate( temperature.getReceivedDate() );

        return temperatureModel;
    }

    @Override
    public Temperature toEntity(TemperatureModel temperature) {
        if ( temperature == null ) {
            return null;
        }

        Temperature temperature1 = new Temperature();

        temperature1.setId( temperature.getId() );
        temperature1.setDegree( temperature.getDegree() );
        temperature1.setReceivedDate( temperature.getReceivedDate() );

        return temperature1;
    }
}
