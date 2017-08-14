package com.ankamagames.dofus.network.messages.game.interactive;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveUsedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number entityId = 0;
  public int elemId = 0;
  public int skillId = 0;
  public int duration = 0;
  public boolean canMove = false;
  public static final int protocolId = 5745;

  public void serialize(ICustomDataOutput param1) {
    if (this.entityId < 0 || this.entityId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.entityId + ") on element entityId.");
    }
    param1.writeVarLong(this.entityId);
    if (this.elemId < 0) {
      throw new Error("Forbidden value (" + this.elemId + ") on element elemId.");
    }
    param1.writeVarInt(this.elemId);
    if (this.skillId < 0) {
      throw new Error("Forbidden value (" + this.skillId + ") on element skillId.");
    }
    param1.writeVarShort(this.skillId);
    if (this.duration < 0) {
      throw new Error("Forbidden value (" + this.duration + ") on element duration.");
    }
    param1.writeVarShort(this.duration);
    param1.writeBoolean(this.canMove);
  }

  public void deserialize(ICustomDataInput param1) {
    this.entityId = param1.readVarUhLong();
    if (this.entityId < 0 || this.entityId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.entityId + ") on element of InteractiveUsedMessage.entityId.");
    }

    this.elemId = param1.readVarUhInt();
    if (this.elemId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.elemId
              + ") on element of InteractiveUseRequestMessage.elemId.");
    }

    this.skillId = param1.readVarUhShort();
    if (this.skillId < 0) {
      throw new Error(
          "Forbidden value (" + this.skillId + ") on element of SkillActionDescription.skillId.");
    }

    this.duration = param1.readVarUhShort();
    if (this.duration < 0) {
      throw new Error(
          "Forbidden value (" + this.duration + ") on element of InteractiveUsedMessage.duration.");
    }

    this.canMove = param1.readBoolean();
  }
}
