package com.ankamagames.dofus.network.messages.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveUseRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int elemId = 0;
  public int skillInstanceUid = 0;
  public static final int protocolId = 5001;

  public void serialize(ICustomDataOutput param1) {
    if (this.elemId < 0) {
      throw new Error("Forbidden value (" + this.elemId + ") on element elemId.");
    }
    param1.writeVarInt(this.elemId);
    if (this.skillInstanceUid < 0) {
      throw new Error(
          "Forbidden value (" + this.skillInstanceUid + ") on element skillInstanceUid.");
    }
    param1.writeVarInt(this.skillInstanceUid);
  }

  public void deserialize(ICustomDataInput param1) {
    this.elemId = param1.readVarUhInt();
    if (this.elemId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.elemId
              + ") on element of InteractiveUseRequestMessage.elemId.");
    }

    this.skillInstanceUid = param1.readInt();
    if (this.skillInstanceUid < 0) {
      throw new Error(
          "Forbidden value ("
              + this.skillInstanceUid
              + ") on element of InteractiveElementSkill.skillInstanceUid.");
    }
  }
}
