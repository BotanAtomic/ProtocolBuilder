package com.ankamagames.dofus.network.enums;

public enum CharacterDeletionErrorEnum {

    DEL_ERR_NO_REASON(1),
    DEL_ERR_TOO_MANY_CHAR_DELETION(2),
    DEL_ERR_BAD_SECRET_ANSWER(3),
    DEL_ERR_RESTRICED_ZONE(4);

    private final int value;
    public CharacterDeletionErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public CharacterDeletionErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}