package com.ankamagames.dofus.network.messages.game.context.mount;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountEmoteIconUsedOkMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int mountId = 0;
  public int reactionType = 0;
  public static final int protocolId = 5978;

  public void serialize(ICustomDataOutput param1) {
    param1.writeVarInt(this.mountId);
    if (this.reactionType < 0) {
      throw new Error("Forbidden value (" + this.reactionType + ") on element reactionType.");
    }
    param1.writeByte(this.reactionType);
  }

  public void deserialize(ICustomDataInput param1) {
    this.mountId = param1.readInt();
    if (this.mountId < 0) {
      throw new Error(
          "Forbidden value (" + this.mountId + ") on element of ObjectEffectMount.mountId.");
    }

    this.reactionType = param1.readByte();
    if (this.reactionType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.reactionType
              + ") on element of MountEmoteIconUsedOkMessage.reactionType.");
    }
  }
}
