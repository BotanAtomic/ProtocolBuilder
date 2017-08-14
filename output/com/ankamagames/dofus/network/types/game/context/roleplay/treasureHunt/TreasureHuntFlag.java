package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntFlag extends Object implements INetworkType {

  public int mapId = 0;
  public int state = 0;
  public static final int protocolId = 473;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.mapId);
    param1.writeByte(this.state);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mapId = param1.readInt();

    this.state = param1.readByte();
    if (this.state < 0) {
      throw new Error("Forbidden value (" + this.state + ") on element of ContentPart.state.");
    }
  }
}
