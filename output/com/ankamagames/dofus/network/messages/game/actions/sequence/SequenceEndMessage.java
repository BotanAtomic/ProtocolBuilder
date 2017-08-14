package com.ankamagames.dofus.network.messages.game.actions.sequence;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SequenceEndMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int actionId = 0;
  public Number authorId = 0;
  public int sequenceType = 0;
  public static final int protocolId = 956;

  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.authorId + ") on element authorId.");
    }
    param1.writeDouble(this.authorId);
    param1.writeByte(this.sequenceType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.actionId = param1.readVarUhShort();
    if (this.actionId < 0) {
      throw new Error(
          "Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
    }

    this.authorId = param1.readDouble();
    if (this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.authorId + ") on element of SequenceStartMessage.authorId.");
    }

    this.sequenceType = param1.readByte();
  }
}
