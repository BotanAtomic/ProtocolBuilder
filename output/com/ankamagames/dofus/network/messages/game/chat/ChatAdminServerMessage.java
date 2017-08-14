package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatAdminServerMessage extends ChatServerMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public static final int protocolId = 6135;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.channel);
    param1.writeUTF(this.content);
    if (this.timestamp < 0) {
      throw new Error("Forbidden value (" + this.timestamp + ") on element timestamp.");
    }
    param1.writeInt(this.timestamp);
    param1.writeUTF(this.fingerprint);

    if (this.senderId < -9.007199254740992E15 || this.senderId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.senderId + ") on element senderId.");
    }
    param1.writeDouble(this.senderId);
    param1.writeUTF(this.senderName);
    if (this.senderAccountId < 0) {
      throw new Error("Forbidden value (" + this.senderAccountId + ") on element senderAccountId.");
    }
    param1.writeInt(this.senderAccountId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();
  }
}
