package com.ankamagames.dofus.network.types.game.look;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SubEntity extends Object implements INetworkType {

  public int bindingPointCategory = 0;
  public int bindingPointIndex = 0;
  public EntityLook subEntityLook;
  private FuncTree _subEntityLooktree;
  public static final int protocolId = 54;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.bindingPointCategory);
    if (this.bindingPointIndex < 0) {
      throw new Error(
          "Forbidden value (" + this.bindingPointIndex + ") on element bindingPointIndex.");
    }
    param1.writeByte(this.bindingPointIndex);
    this.subEntityLook.serializeAs_EntityLook(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.bindingPointCategory = param1.readByte();
    if (this.bindingPointCategory < 0) {
      throw new Error(
          "Forbidden value ("
              + this.bindingPointCategory
              + ") on element of SubEntity.bindingPointCategory.");
    }

    this.bindingPointIndex = param1.readByte();
    if (this.bindingPointIndex < 0) {
      throw new Error(
          "Forbidden value ("
              + this.bindingPointIndex
              + ") on element of SubEntity.bindingPointIndex.");
    }

    this.subEntityLook = new EntityLook();
    this.subEntityLook.deserialize(param1);
  }
}
