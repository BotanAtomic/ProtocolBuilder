package com.ankamagames.dofus.network.types.game.mount;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ItemDurability extends Object implements INetworkType {

  public int durability = 0;
  public int durabilityMax = 0;
  public static final int protocolId = 168;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.durability);
    param1.writeShort(this.durabilityMax);
  }

  public void deserialize(ICustomDataInput param1) {
    this.durability = param1.readShort();

    this.durabilityMax = param1.readShort();
  }
}
