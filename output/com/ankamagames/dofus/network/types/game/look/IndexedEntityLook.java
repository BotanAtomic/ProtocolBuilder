package com.ankamagames.dofus.network.types.game.look;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IndexedEntityLook extends Object implements INetworkType {

  public EntityLook look;
  public int index = 0;
  private FuncTree _looktree;
  public static final int protocolId = 405;

  public void serialize(ICustomDataOutput param1) {
    this.look.serializeAs_EntityLook(param1);
    if (this.index < 0) {
      throw new Error("Forbidden value (" + this.index + ") on element index.");
    }
    param1.writeByte(this.index);
  }

  public void deserialize(ICustomDataInput param1) {
    this.look = new EntityLook();
    this.look.deserialize(param1);
    this.index = param1.readByte();
    if (this.index < 0) {
      throw new Error(
          "Forbidden value (" + this.index + ") on element of IndexedEntityLook.index.");
    }
  }
}
