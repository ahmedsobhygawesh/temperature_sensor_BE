package com.service.mapper;

import com.model.DeviceModel;
import com.model.TemperatureModel;
import com.repository.entity.Device;
import com.repository.entity.Temperature;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-07-10T11:26:45+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_221 (Oracle Corporation)"
)
@Component
public class DeviceMapperImpl implements DeviceMapper {

    @Autowired
    private TemperatureMapper temperatureMapper;

    @Override
    public DeviceModel toModel(Device device) {
        if ( device == null ) {
            return null;
        }

        DeviceModel deviceModel = new DeviceModel();

        deviceModel.setId( device.getId() );
        deviceModel.setName( device.getName() );
        deviceModel.setModel( device.getModel() );
        deviceModel.setTemperatures( temperatureListToTemperatureModelList( device.getTemperatures() ) );

        return deviceModel;
    }

    @Override
    public Device toEntity(DeviceModel device) {
        if ( device == null ) {
            return null;
        }

        Device device1 = new Device();

        device1.setId( device.getId() );
        device1.setName( device.getName() );
        device1.setModel( device.getModel() );
        device1.setTemperatures( temperatureModelListToTemperatureList( device.getTemperatures() ) );

        return device1;
    }

    protected List<TemperatureModel> temperatureListToTemperatureModelList(List<Temperature> list) {
        if ( list == null ) {
            return null;
        }

        List<TemperatureModel> list1 = new ArrayList<TemperatureModel>( list.size() );
        for ( Temperature temperature : list ) {
            list1.add( temperatureMapper.toModel( temperature ) );
        }

        return list1;
    }

    protected List<Temperature> temperatureModelListToTemperatureList(List<TemperatureModel> list) {
        if ( list == null ) {
            return null;
        }

        List<Temperature> list1 = new ArrayList<Temperature>( list.size() );
        for ( TemperatureModel temperatureModel : list ) {
            list1.add( temperatureMapper.toEntity( temperatureModel ) );
        }

        return list1;
    }
}
