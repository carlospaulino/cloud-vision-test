package com.carlospaulino.vision;

import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.Feature;
import com.google.api.services.vision.v1.model.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.google.common.io.BaseEncoding.base64;
import static com.google.common.io.Files.toByteArray;

final class AnnotateImageRequestBuilder {
    private FeatureType featureType = FeatureType.LABEL_DETECTION;
    private File file;
    private int maxResults = 1;

    AnnotateImageRequestBuilder setFeatureType(final FeatureType featureType) {
        this.featureType = featureType;
        return this;
    }

    AnnotateImageRequestBuilder setFile(final File file) {
        this.file = file;
        return this;
    }

    AnnotateImageRequestBuilder setMaxResults(final int maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    AnnotateImageRequest build() {
        try {
            return new AnnotateImageRequest()
                       .setFeatures(new ArrayList<Feature>() {{
                           add(new Feature()
                                   .setMaxResults(maxResults)
                                   .setType(featureType.name()));
                       }})
                       .setImage(new Image().setContent(base64().encode(toByteArray(file))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
