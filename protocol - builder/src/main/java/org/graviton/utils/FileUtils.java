package org.graviton.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Botan on 12/08/2017 : 21:05
 */
public class FileUtils {

    public static void writeFile(String content, String path) {
        File file = new File(Paths.get("output/" + path).getParent().toString());
        if (!file.exists()) file.mkdirs();

        try {
            Files.write(Paths.get("output/" + path), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(URL url) {
        try {
            return new String(Files.readAllBytes(Paths.get(url.toURI())));
        } catch (IOException | URISyntaxException e) {
            return "";
        }
    }

}
