package org.graviton.core;

import org.graviton.attribute.ActionScriptClass;
import org.graviton.builder.JavaClassWriter;
import org.graviton.utils.FileUtils;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Botan on 12/08/2017 : 00:47
 */
class ProtocolBuilder {

    static void build() throws Exception {
       // Files.list(Paths.get(Main.class.getClassLoader().getResource(System.getProperty("default.enum.path")).toURI()))
         //       .forEach(file -> JavaClassWriter.writeEnum(new ActionScriptClass(FileUtils.readFile(file.toUri()))));

        new ActionScriptClass(FileUtils.readFile(Main.class.getClassLoader().getResource("data/messages/queues/LoginQueueStatusMessage.as").toURI()));

    }

}
