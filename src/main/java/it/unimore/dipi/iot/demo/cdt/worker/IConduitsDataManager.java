package it.unimore.dipi.iot.demo.cdt.worker;

import it.unimore.dipi.iot.demo.cdt.exception.ConduitsDataManagerException;
import it.unimore.dipi.iot.demo.cdt.model.ConduitConfigurationParameter;
import it.unimore.dipi.iot.demo.cdt.model.ConduitDigitalTwinDescriptor;
import it.unimore.dipi.iot.demo.cdt.model.ZoneDigitalTwinDescriptor;

import java.util.Map;

/**
 * @author Marco Picone, Ph.D. - picone.m@gmail.com
 * @project http-iot-api-demo
 * @created 05/10/2020 - 11:44
 */
public interface IConduitsDataManager {

    public ConduitDigitalTwinDescriptor getConduitDescriptor() throws ConduitsDataManagerException;

    public ConduitDigitalTwinDescriptor updateConduitDescriptor (ConduitDigitalTwinDescriptor conduitDigitalTwinDescriptor) throws ConduitsDataManagerException;

    public ConduitDigitalTwinDescriptor setFirstZoneDigitalTwin(ZoneDigitalTwinDescriptor zoneDigitalTwinDescriptor) throws ConduitsDataManagerException;

    public ConduitDigitalTwinDescriptor setSecondZoneDigitalTwin(ZoneDigitalTwinDescriptor zoneDigitalTwinDescriptor) throws ConduitsDataManagerException;

    public ConduitDigitalTwinDescriptor updateConduitAttributes(Map<String, ConduitConfigurationParameter> attributes) throws ConduitsDataManagerException;
}
