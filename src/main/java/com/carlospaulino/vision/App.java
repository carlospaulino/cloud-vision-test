package com.carlospaulino.vision;

import com.google.api.services.vision.v1.Vision;
import com.google.api.services.vision.v1.VisionRequestInitializer;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesResponse;
import com.google.api.services.vision.v1.model.EntityAnnotation;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static com.carlospaulino.vision.BatchAnnotateImagesRequestFactory.fromParams;
import static com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport;
import static com.google.api.client.json.jackson2.JacksonFactory.getDefaultInstance;
import static java.lang.String.format;

public class App {
    private static final String API_KEY  = System.getenv("VISION_API_KEY");
    private static final String APP_NAME = "com.carlos.paulino.vision";

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        Params params = Params.parse(args);

        if (API_KEY == null && params.getApiKey() == null) {
            throw new RuntimeException("Missing API KEY");
        }

        Vision vision = getVisionClient();

        BatchAnnotateImagesResponse result = vision
                                                 .images()
                                                 .annotate(fromParams(params))
                                                 .execute();

        if (result.getResponses() != null && !result.getResponses().isEmpty()) {
            System.out.println(format("Labels for %s:", params.getFile().getName()));
            List<EntityAnnotation> entityAnnotations = result.getResponses().get(0).getLabelAnnotations();
            for (EntityAnnotation entityAnnotation : entityAnnotations) {
                System.out.println(entityAnnotation.getDescription());
            }
        } else if (result.getResponses().isEmpty()) {
            System.out.println(format("No labels found for %s:", params.getFile().getName()));
        } {
            System.out.println("Something went wrong. Try again.");
        }
    }

    private static Vision getVisionClient() throws GeneralSecurityException, IOException {
        return new Vision.Builder(newTrustedTransport(), getDefaultInstance(), null)
                   .setApplicationName(APP_NAME)
                   .setGoogleClientRequestInitializer(new VisionRequestInitializer(API_KEY))
                   .build();
    }
}

