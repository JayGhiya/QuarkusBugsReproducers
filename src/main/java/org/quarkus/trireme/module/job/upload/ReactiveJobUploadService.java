package org.quarkus.trireme.module.job.upload;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.ext.web.client.WebClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.spi.ContentType;
import org.quarkus.trireme.module.models.MultiPart;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

@ApplicationScoped
public class ReactiveJobUploadService implements ReactiveJobUploadInterface {

    private final Vertx vertx;

    private final WebClient client;

    private static final Logger LOG = Logger.getLogger(ReactiveJobUploadService.class);

    @RestClient
    ReactiveJobUploadReactiveRestEasyInterface easyInterface;

    @ConfigProperty(name = "flink.jar.hl7.name")
    protected String hl7JarName;

    @ConfigProperty(name = "flink.port")
    protected int flinkPort;

    @ConfigProperty(name = "flink.host.ip")
    protected String flinkHostIp;

    protected String jarId;

    @Inject
    public ReactiveJobUploadService(Vertx vertx) {
        this.vertx = vertx;
        this.client = WebClient.create(vertx);
    }

    @Override
    public void uploadIfJobDoesNotExist() {


       /* MultipartForm multipartForm = formMultiPart();
        Uni<JarUploadResponse> uploadResponseUni = uploadJar(multipartForm);
        return uploadResponseUni;
*/
        MultiPart multipart = new MultiPart();

        multipart.file = new File("FlinkTcpSocketReaderPoc-1.0-SNAPSHOT.jar");
        LOG.info(multipart.file.getName());
        //multipart.fileName = new String("FlinkTcpSocketReaderPoc-1.0-SNAPSHOT.jar");
         Uni.createFrom().completionStage(easyInterface.uploadFile("multipart/form-data",multipart))
                .subscribe().with(s -> LOG.info("Successfully sent"));

    }


}
