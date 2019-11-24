package framework.utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    static final Logger log = Logger.getLogger(FileManager.class);

    public static boolean isSaved(String downloadPath, String fileName) {
        File downloadedFile = null;
        File file = new File(downloadPath);
        File[] dirContents = file.listFiles();
        assert dirContents != null;
        log.info("Checked if file is in the folder");
        for (File dirContent : dirContents) {
            if (dirContent.getName().equals(fileName)) {
                downloadedFile = dirContent;
            }
        }
        assert downloadedFile != null;
        return (downloadedFile.getName().equals(fileName));
    }

    public static void writer(ArrayList<String> data, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        for (String datum : data) {
            fileWriter.write(datum+"\n");
        }
        fileWriter.close();
    }
}
