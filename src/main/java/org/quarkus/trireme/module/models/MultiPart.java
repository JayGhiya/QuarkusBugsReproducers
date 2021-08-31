package org.quarkus.trireme.module.models;

import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.File;


public class MultiPart {
    @FormParam("jarfile")
    @PartType(MediaType.MULTIPART_FORM_DATA)
    public File file;
}
