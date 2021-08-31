package org.quarkus.trireme.module.job.upload;


import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.MultipartForm;
import org.quarkus.trireme.module.models.MultiPart;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(configKey="flink-api")
@Path("/jars")
public interface ReactiveJobUploadReactiveRestEasyInterface {

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<String> uploadFile(@HeaderParam("Content-Type") String contentType, @MultipartForm MultiPart multipart);

}
