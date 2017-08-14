package com.ankamagames.dofus.network.types.game.inventory.preset;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PresetItem extends Object implements INetworkType {

  public int position = 63;
  public int objGid = 0;
  public int objUid = 0;
  public static final int protocolId = 354;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.position);
    if (this.objGid < 0) {
      throw new Exception("Forbidden value (" + this.objGid + ") on element objGid.");
    }
    param1.writeVarShort(this.objGid);
    if (this.objUid < 0) {
      throw new Exception("Forbidden value (" + this.objUid + ") on element objUid.");
    }
    param1.writeVarInt(this.objUid);
  }

  public void deserialize(ICustomDataInput param1) {
    this.position = param1.readUnsignedByte();
    if (this.position < 0 || this.position > 255) {
      throw new Exception(
          "Forbidden value (" + this.position + ") on element of PresetItem.position.");
    }

    this.objGid = param1.readVarUhShort();
    if (this.objGid < 0) {
      throw new Exception("Forbidden value (" + this.objGid + ") on element of PresetItem.objGid.");
    }

    this.objUid = param1.readVarUhInt();
    if (this.objUid < 0) {
      throw new Exception("Forbidden value (" + this.objUid + ") on element of PresetItem.objUid.");
    }
  }
}
