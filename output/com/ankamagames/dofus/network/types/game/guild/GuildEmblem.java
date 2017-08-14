package com.ankamagames.dofus.network.types.game.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildEmblem extends Object implements INetworkType {

  public int symbolShape = 0;
  public int symbolColor = 0;
  public int backgroundShape = 0;
  public int backgroundColor = 0;
  public static final int protocolId = 87;

  public void serialize(ICustomDataOutput param1) {
    if (this.symbolShape < 0) {
      throw new Exception("Forbidden value (" + this.symbolShape + ") on element symbolShape.");
    }
    param1.writeVarShort(this.symbolShape);
    param1.writeInt(this.symbolColor);
    if (this.backgroundShape < 0) {
      throw new Exception(
          "Forbidden value (" + this.backgroundShape + ") on element backgroundShape.");
    }
    param1.writeByte(this.backgroundShape);
    param1.writeInt(this.backgroundColor);
  }

  public void deserialize(ICustomDataInput param1) {
    this.symbolShape = param1.readVarUhShort();
    if (this.symbolShape < 0) {
      throw new Exception(
          "Forbidden value (" + this.symbolShape + ") on element of GuildEmblem.symbolShape.");
    }

    this.symbolColor = param1.readInt();

    this.backgroundShape = param1.readByte();
    if (this.backgroundShape < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.backgroundShape
              + ") on element of GuildEmblem.backgroundShape.");
    }

    this.backgroundColor = param1.readInt();
  }
}
