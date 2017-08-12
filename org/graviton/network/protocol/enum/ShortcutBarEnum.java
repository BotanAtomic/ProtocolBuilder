package org.graviton.network.protocol.enums;

public enum ShortcutBarEnum {

    GENERAL_SHORTCUT_BAR(0),
    SPELL_SHORTCUT_BAR(1);

    private final int value;
    public ShortcutBarEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}