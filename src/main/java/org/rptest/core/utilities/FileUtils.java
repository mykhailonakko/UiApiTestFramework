package org.rptest.core.utilities;

import lombok.experimental.UtilityClass;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.rptest.core.config.Property;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@UtilityClass
public class FileUtils {
    public static List<CSVRecord> readCSV(String filePath) throws IOException {
        Reader reader = new FileReader(filePath);
        CSVParser parser = CSVFormat.DEFAULT
                .builder()
                .setHeader()
                .setSkipHeaderRecord(true)
                .build()
                .parse(reader);
        List<CSVRecord> records = parser.getRecords();
        parser.close();
        reader.close();
        return records;
    }

    public static Path getScreenshotFolderPath() throws IOException {
        Path screenshotDir = Paths.get(Property.COMMON_PROPERTY.screenshotsPath());
        if (!Files.exists(screenshotDir)) {
            Files.createDirectories(screenshotDir);
        }
        return screenshotDir;
    }
}