package it.unimore.dipi.iot.demo.cdt.worker;


import it.unimore.dipi.iot.demo.cdt.exception.ConduitsDataManagerException;
import it.unimore.dipi.iot.demo.cdt.model.ConduitConfigurationParameter;
import it.unimore.dipi.iot.demo.cdt.model.ConduitDigitalTwinDescriptor;
import it.unimore.dipi.iot.demo.cdt.model.ZoneDigitalTwinDescriptor;

import java.util.Map;
import java.util.UUID;

/**
 *
 * Demo IoT Inventory Data Manager handling all data in a local cache implemented through Maps and Lists
 *
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project http-iot-api-demo
 * @created 05/10/2020 - 11:48
 */
public class DefaultConduitsDataManger implements IConduitsDataManager {

    private ConduitDigitalTwinDescriptor conduitDigitalTwinDescriptor = null;

    public DefaultConduitsDataManger() {
        this.conduitDigitalTwinDescriptor = new ConduitDigitalTwinDescriptor(UUID.randomUUID().toString(), ConduitDigitalTwinDescriptor.CONDUIT_DT_TYPE);
    }


    @Override
    public ConduitDigitalTwinDescriptor getConduitDescriptor() throws ConduitsDataManagerException {
        return conduitDigitalTwinDescriptor;
    }

    @Override
    public ConduitDigitalTwinDescriptor updateConduitDescriptor(ConduitDigitalTwinDescriptor conduitDigitalTwinDescriptor) throws ConduitsDataManagerException {

        if(conduitDigitalTwinDescriptor != null){
            this.conduitDigitalTwinDescriptor.setConduitId(conduitDigitalTwinDescriptor.getConduitId());
            this.conduitDigitalTwinDescriptor.setFirstZoneDigitalTwinDescriptor(conduitDigitalTwinDescriptor.getFirstZoneDigitalTwinDescriptor());
            this.conduitDigitalTwinDescriptor.setSecondZoneDigitalTwinDescriptor(conduitDigitalTwinDescriptor.getSecondZoneDigitalTwinDescriptor());
            this.conduitDigitalTwinDescriptor.setAttributes(conduitDigitalTwinDescriptor.getAttributes());
        }

        return this.conduitDigitalTwinDescriptor;
    }

    @Override
    public ConduitDigitalTwinDescriptor setFirstZoneDigitalTwin(ZoneDigitalTwinDescriptor zoneDigitalTwinDescriptor) throws ConduitsDataManagerException {
        conduitDigitalTwinDescriptor.setFirstZoneDigitalTwinDescriptor(zoneDigitalTwinDescriptor);
        return this.conduitDigitalTwinDescriptor;
    }

    @Override
    public ConduitDigitalTwinDescriptor setSecondZoneDigitalTwin(ZoneDigitalTwinDescriptor zoneDigitalTwinDescriptor) throws ConduitsDataManagerException {
        conduitDigitalTwinDescriptor.setSecondZoneDigitalTwinDescriptor(zoneDigitalTwinDescriptor);
        return this.conduitDigitalTwinDescriptor;
    }

    @Override
    public ConduitDigitalTwinDescriptor updateConduitAttributes(Map<String, ConduitConfigurationParameter> attributes) throws ConduitsDataManagerException {
        conduitDigitalTwinDescriptor.setAttributes(attributes);
        return this.conduitDigitalTwinDescriptor;
    }
}
