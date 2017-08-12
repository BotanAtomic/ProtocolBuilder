package org.graviton.core;

public class Main {

    public static void main(String[] args) throws Exception {
        //TODO : Configuration file
        System.setProperty("default.enum.package", "org.graviton.network.protocol.enums");
        System.setProperty("default.enum.path", "data/enums/");
        System.setProperty("export.enum.path", "org/graviton/network/protocol/enum/");

        ProtocolBuilder.build();
    }

}
