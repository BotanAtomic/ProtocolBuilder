package org.graviton.core;


import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.graviton.attribute.ASClass;
import org.graviton.utils.FileUtils;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.graviton.converter.ActionScriptConverter.convertToJava;
import static org.graviton.converter.ActionScriptConverter.convertToJavaEnum;

/**
 * Created by Botan on 12/08/2017 : 00:47
 */
class ProtocolBuilder {

    private static final List<ASClass> classMap = new CopyOnWriteArrayList<>();
    private static final Map<String, ASClass.Function> functionMap = new ConcurrentHashMap<>();

    static void build() throws Exception {
        buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.enum.path")).toURI()), true);
        buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.messages.path")).toURI()), false);
        buildFiles(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.types.path")).toURI()), false);

        classMap.forEach(asClass -> {
            asClass.replaceMainFunction(functionMap);
            FileUtils.writeFile(format(convertToJava(asClass)), asClass.buildExportPath());
        });

    }

    private static void buildFiles(Path path, boolean enumeration) throws IOException {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                if (!attributes.isDirectory()) {
                    ASClass asClass = new ASClass(FileUtils.readFile(file.toUri().toURL()));
                    if (enumeration) {
                        String converted = convertToJavaEnum(asClass);
                        FileUtils.writeFile(format(converted), asClass.buildExportPath());
                    } else {
                        classMap.add(asClass);
                        asClass.getFunctions().forEach(function -> {
                            if (!function.getName().equals("serialize") && !function.equals("deserialize"))
                                functionMap.put(function.getName(), function);
                        });
                    }
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static String format(String content) {
        try {
            return new Formatter().formatSource(content);
        } catch (FormatterException e) {
            e.getMessage();
            return content;
        }
    }

}
