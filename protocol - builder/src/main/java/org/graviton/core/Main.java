package org.graviton.core;


public class Main {

    public static void main(String[] args) throws Exception {
        System.setProperty("default.enum.path", "enums/");
        System.setProperty("default.messages.path", "messages/");
        System.setProperty("default.types.path", "types/");

        ProtocolBuilder.build();
    }


}
