package org.graviton.core;

import org.graviton.attribute.ActionScriptClass;
import org.graviton.builder.JavaClassWriter;
import org.graviton.utils.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

/**
 * Created by Botan on 12/08/2017 : 00:47
 */
class ProtocolBuilder {

    static void build() throws Exception {
     //   buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.enum.path")).toURI()), true);
       // buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.messages.path")).toURI()), false);
        //buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.types.path")).toURI()), false);
        JavaClassWriter.write(new ActionScriptClass(FileUtils.readFile(
                Main.class.getClassLoader().getResource("messages/server/basic/SystemMessageDisplayMessage.as").toURI()
        )), false);

    }

    private static void buildFiles(Path path, boolean enumeration) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                if (!attributes.isDirectory())
                    JavaClassWriter.write(new ActionScriptClass(FileUtils.readFile(file.toUri())), enumeration);
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
