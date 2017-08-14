package com.ankamagames.dofus.network.messages.game.chat.smiley;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatSmileyMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number entityId = 0;
  public int smileyId = 0;
  public int accountId = 0;
  public static final int protocolId = 801;

  public void serialize(ICustomDataOutput param1) {
    if (this.entityId < -9.007199254740992E15 || this.entityId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.entityId + ") on element entityId.");
    }
    param1.writeDouble(this.entityId);
    if (this.smileyId < 0) {
      throw new Error("Forbidden value (" + this.smileyId + ") on element smileyId.");
    }
    param1.writeVarShort(this.smileyId);
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.entityId = param1.readVarUhLong();
    if (this.entityId < 0 || this.entityId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.entityId + ") on element of InteractiveUsedMessage.entityId.");
    }

    this.smileyId = param1.readVarUhShort();
    if (this.smileyId < 0) {
      throw new Error(
          "Forbidden value (" + this.smileyId + ") on element of ShortcutSmiley.smileyId.");
    }

    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Error(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }
  }
}
