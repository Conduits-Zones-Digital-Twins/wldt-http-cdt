package it.unimore.dipi.iot.demo.cdt.worker;

import com.codahale.metrics.annotation.Timed;
import io.dropwizard.jersey.errors.ErrorMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.unimore.dipi.iot.demo.cdt.dto.UpdateConduitRequest;
import it.unimore.dipi.iot.demo.cdt.model.ConduitDigitalTwinDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/api/conduit/")
@Api("CDT default API Endpoint")
public class ConduitResource {

    final protected Logger logger = LoggerFactory.getLogger(ConduitResource.class);

    public static class MissingKeyException extends Exception{}
    final CdtHttpServiceConfig conf;

    public ConduitResource(CdtHttpServiceConfig conf) {
        this.conf = conf;
    }

    @GET
    @Path("/")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Get Conduit Descriptor")
    public Response getConduit(@Context ContainerRequestContext req) {

        try {


            ConduitDigitalTwinDescriptor conduitDigitalTwinDescriptor = this.conf.getConduitsDataManager().getConduitDescriptor();

            if(conduitDigitalTwinDescriptor == null)
                return Response.status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.NOT_FOUND.getStatusCode(),"Resource Not Found !")).build();

            return Response.ok(conduitDigitalTwinDescriptor).build();

        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),"Internal Server Error !")).build();
        }
    }

    @PUT
    @Path("/")
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Update an existing Edge Node")
    public Response updateDigitalTwin(@Context ContainerRequestContext req,
                                      @Context UriInfo uriInfo,
                                      UpdateConduitRequest updateConduitRequest) {

        try {

            logger.info("Incoming Edge Node ({}) Update Request: {}", updateConduitRequest);

            //Check if the request is valid and Path Id match resource id
            if(updateConduitRequest == null)
                return Response.status(Response.Status.BAD_REQUEST).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.BAD_REQUEST.getStatusCode(),"Invalid request ! Check Resource Id")).build();

            this.conf.getConduitsDataManager().updateConduitDescriptor(updateConduitRequest);

            return Response.noContent().build();

        } catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON_TYPE).entity(new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),"Internal Server Error !")).build();
        }
    }

}
