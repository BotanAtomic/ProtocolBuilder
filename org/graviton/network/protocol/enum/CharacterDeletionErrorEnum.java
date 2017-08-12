package org.graviton.network.protocol.enums;

public enum CharacterDeletionErrorEnum {

    DEL_ERR_NO_REASON(1),
    DEL_ERR_TOO_MANY_CHAR_DELETION(2),
    DEL_ERR_BAD_SECRET_ANSWER(3),
    DEL_ERR_RESTRICED_ZONE(4);

    private final int value;
    public CharacterDeletionErrorEnum(int value) {
        this.value = value;
    }

    public int values() { return this.value; }

}