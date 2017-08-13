package com.ankamagames.dofus.network.enums;

public enum ShortcutBarEnum {

    GENERAL_SHORTCUT_BAR(0),
    SPELL_SHORTCUT_BAR(1);

    private final int value;
    public ShortcutBarEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public ShortcutBarEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}