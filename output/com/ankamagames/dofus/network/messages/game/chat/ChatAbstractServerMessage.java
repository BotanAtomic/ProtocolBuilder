package com.ankamagames.dofus.network.messages.game.chat;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatAbstractServerMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int channel = 0;
  public String content = "";
  public int timestamp = 0;
  public String fingerprint = "";
  public static final int protocolId = 880;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.channel);
    param1.writeUTF(this.content);
    if (this.timestamp < 0) {
      throw new Exception("Forbidden value (" + this.timestamp + ") on element timestamp.");
    }
    param1.writeInt(this.timestamp);
    param1.writeUTF(this.fingerprint);
  }

  public void deserialize(ICustomDataInput param1) {
    this.channel = param1.readByte();
    if (this.channel < 0) {
      throw new Exception(
          "Forbidden value (" + this.channel + ") on element of ChatMessageReportMessage.channel.");
    }

    this.content = param1.readUTF();

    this.timestamp = param1.readDouble();
    if (this.timestamp < -9.007199254740992E15 || this.timestamp > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.timestamp
              + ") on element of SubscriptionUpdateMessage.timestamp.");
    }

    this.fingerprint = param1.readUTF();
  }
}
