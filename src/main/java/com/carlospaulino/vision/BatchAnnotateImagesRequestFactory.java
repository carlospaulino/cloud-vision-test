package com.carlospaulino.vision;

import com.google.api.services.vision.v1.model.AnnotateImageRequest;
import com.google.api.services.vision.v1.model.BatchAnnotateImagesRequest;
import java.util.List;
import javax.annotation.Nonnull;

import static com.carlospaulino.vision.FeatureType.LABEL_DETECTION;
import static com.google.common.collect.Lists.newArrayList;

public final class BatchAnnotateImagesRequestFactory {

    public static BatchAnnotateImagesRequest fromParams(@Nonnull Params params) {
        List<AnnotateImageRequest> requests = newArrayList(new AnnotateImageRequestBuilder()
                                                               .setMaxResults(params.getMaxResults())
                                                               .setFile(params.getFile())
                                                               .setFeatureType(LABEL_DETECTION)
                                                               .build());

        return new BatchAnnotateImagesRequest().setRequests(requests);
    }

    private BatchAnnotateImagesRequestFactory() {

    }
}
