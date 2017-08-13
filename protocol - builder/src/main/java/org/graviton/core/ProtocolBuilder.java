package org.graviton.core;

import org.graviton.attribute.ActionScriptClass;
import org.graviton.builder.JavaClassWriter;
import org.graviton.utils.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

/**
 * Created by Botan on 12/08/2017 : 00:47
 */
class ProtocolBuilder {

    private static final List<ActionScriptClass> protocolClass = new CopyOnWriteArrayList<>();

    static void build() throws Exception {
        // buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.enum.path")).toURI()), true);
        buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.messages.path")).toURI()), false);
        buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.types.path")).toURI()), false);

        //protocolClass.add(new ActionScriptClass(FileUtils.readFile(Main.class.getClassLoader().getResource("messages/authorized/AdminCommandMessage.as").toURI())));
        //protocolClass.add(new ActionScriptClass(FileUtils.readFile(Main.class.getClassLoader().getResource("messages/authorized/AdminQuietCommandMessage.as").toURI())));

        protocolClass.forEach(c -> JavaClassWriter.writeClass(c.format(protocolClass)));
    }

    private static void buildFiles(Path path, boolean enumeration) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                if (!attributes.isDirectory())
                    protocolClass.add(new ActionScriptClass(FileUtils.readFile(file.toUri())));
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
