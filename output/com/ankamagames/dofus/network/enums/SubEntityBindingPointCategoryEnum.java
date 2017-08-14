package com.ankamagames.dofus.network.enums;

public enum SubEntityBindingPointCategoryEnum {
  HOOK_POINT_CATEGORY_UNUSED(0),
  HOOK_POINT_CATEGORY_PET(1),
  HOOK_POINT_CATEGORY_MOUNT_DRIVER(2),
  HOOK_POINT_CATEGORY_LIFTED_ENTITY(3),
  HOOK_POINT_CATEGORY_BASE_BACKGROUND(4),
  HOOK_POINT_CATEGORY_MERCHANT_BAG(5),
  HOOK_POINT_CATEGORY_BASE_FOREGROUND(6),
  HOOK_POINT_CATEGORY_PET_FOLLOWER(7),
  HOOK_POINT_CATEGORY_UNDERWATER_BUBBLES(8);
  private final int value;

  public SubEntityBindingPointCategoryEnum(int value) {
    this.value = value;
  }

  public int value() {
    return this.value;
  }

  public SubEntityBindingPointCategoryEnum get(int value) {
    return Stream.of(values()).filter(current -> current.value == value).findAny().orElse(null);
  }
}
