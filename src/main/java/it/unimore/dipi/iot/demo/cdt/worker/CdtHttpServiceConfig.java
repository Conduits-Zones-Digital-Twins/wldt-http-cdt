package it.unimore.dipi.iot.demo.cdt.worker;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class CdtHttpServiceConfig extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    private IConduitsDataManager conduitsZonesDataManager = null;

    public IConduitsDataManager getConduitsDataManager(){

        if(this.conduitsZonesDataManager == null)
            this.conduitsZonesDataManager = new DefaultConduitsDataManger();

        return this.conduitsZonesDataManager;
    }
}