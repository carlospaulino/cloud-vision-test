package com.carlospaulino.vision;

public enum FeatureType {
    TYPE_UNSPECIFIED, // Unspecified feature type.
    FACE_DETECTION, // Run face detection.
    LANDMARK_DETECTION, // Run landmark detection.
    LOGO_DETECTION, // Run logo detection.
    LABEL_DETECTION, // Run label detection.
    TEXT_DETECTION, // Run OCR.
    SAFE_SEARCH_DETECTION, // Run various computer vision models to compute image safe-search properties.
    IMAGE_PROPERTIES
}
