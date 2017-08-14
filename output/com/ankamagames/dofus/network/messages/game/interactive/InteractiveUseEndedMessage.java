package com.ankamagames.dofus.network.messages.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveUseEndedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int elemId = 0;
  public int skillId = 0;
  public static final int protocolId = 6112;

  public void serialize(ICustomDataOutput param1) {
    if (this.elemId < 0) {
      throw new Exception("Forbidden value (" + this.elemId + ") on element elemId.");
    }
    param1.writeVarInt(this.elemId);
    if (this.skillId < 0) {
      throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.elemId = param1.readVarUhInt();
    if (this.elemId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.elemId
              + ") on element of InteractiveUseRequestMessage.elemId.");
    }

    this.skillId = param1.readVarUhShort();
    if (this.skillId < 0) {
      throw new Exception(
          "Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
    }
  }
}
