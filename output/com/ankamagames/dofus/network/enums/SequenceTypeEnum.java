package com.ankamagames.dofus.network.enums;

public enum SequenceTypeEnum {

    SEQUENCE_SPELL(1;),
    SEQUENCE_WEAPON(2;),
    SEQUENCE_GLYPH_TRAP(3;),
    SEQUENCE_TRIGGERED(4;),
    SEQUENCE_MOVE(5;),
    SEQUENCE_CHARACTER_DEATH(6;),
    SEQUENCE_TURN_START(7;),
    SEQUENCE_TURN_END(8;),
    SEQUENCE_FIGHT_START(9;);

    private final int value;
    public SequenceTypeEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public SequenceTypeEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}