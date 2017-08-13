package com.ankamagames.dofus.network.enums;

public enum ObjectErrorEnum {

    INVENTORY_FULL(1),
    CANNOT_EQUIP_TWICE(2),
    NOT_TRADABLE(3),
    CANNOT_DROP(4),
    CANNOT_DROP_NO_PLACE(5),
    CANNOT_DESTROY(6),
    LEVEL_TOO_LOW(7),
    LIVING_OBJECT_REFUSED_FOOD(8),
    CANNOT_UNEQUIP(9),
    CANNOT_EQUIP_HERE(10),
    CRITERIONS(11),
    SYMBIOTIC_OBJECT_ERROR(12);

    private final int value;
    public ObjectErrorEnum(int value) {
        this.value = value;
    }

    public int value() {
      return this.value;
    }

    public ObjectErrorEnum get(int value) {
        return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
    }

}