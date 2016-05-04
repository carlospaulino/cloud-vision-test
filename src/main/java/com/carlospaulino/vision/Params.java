package com.carlospaulino.vision;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.io.File;

public final class Params {
    @Parameter(
        names = { "-maxResults" },
        description = "Maximum number of results of this type.")
    private int maxResults = 1;

    @Parameter(names = "-file",
        description = "Image to perform Google Cloud Vision API tasks over.",
        required = true, converter = FileConverter.class)
    private File file;

    @Parameter(
        names = { "-apiKey" },
        description = "Google Cloud API KEY.")
    private String apiKey;

    public int getMaxResults() {
        return maxResults;
    }

    public File getFile() {
        return file;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static Params parse(String[] args) {
        Params params = new Params();
        new JCommander(params, args);

        if (params.file == null) {
            throw new RuntimeException("Missing file param");
        }

        if (!params.file.exists()) {
            throw new RuntimeException("File does not exists");
        }

        return params;
    }

    public static class FileConverter implements IStringConverter<File> {
        @Override
        public File convert(String value) {
            return new File(value);
        }
    }
}
