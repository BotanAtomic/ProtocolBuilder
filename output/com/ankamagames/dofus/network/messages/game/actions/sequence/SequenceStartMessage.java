package com.ankamagames.dofus.network.messages.game.actions.sequence;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class SequenceStartMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int sequenceType = 0;
  public Number authorId = 0;
  public static final int protocolId = 955;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.sequenceType);
    if (this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.authorId + ") on element authorId.");
    }
    param1.writeDouble(this.authorId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.sequenceType = param1.readByte();

    this.authorId = param1.readDouble();
    if (this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.authorId + ") on element of SequenceStartMessage.authorId.");
    }
  }
}
