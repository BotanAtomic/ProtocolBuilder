package com.ankamagames.dofus.network.types.game.character.status;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PlayerStatus extends Object implements INetworkType {

  public int statusId = 1;
  public static final int protocolId = 415;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.statusId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.statusId = param1.readByte();
    if (this.statusId < 0) {
      throw new Error(
          "Forbidden value (" + this.statusId + ") on element of PlayerStatus.statusId.");
    }
  }
}
