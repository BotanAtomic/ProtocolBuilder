package com.ankamagames.dofus.network.messages.game.context.roleplay.npc;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NpcDialogReplyMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int replyId = 0;
  public static final int protocolId = 5616;

  public void serialize(ICustomDataOutput param1) {
    if (this.replyId < 0) {
      throw new Exception("Forbidden value (" + this.replyId + ") on element replyId.");
    }
    param1.writeVarInt(this.replyId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.replyId = param1.readVarUhInt();
    if (this.replyId < 0) {
      throw new Exception(
          "Forbidden value (" + this.replyId + ") on element of NpcDialogReplyMessage.replyId.");
    }
  }
}
