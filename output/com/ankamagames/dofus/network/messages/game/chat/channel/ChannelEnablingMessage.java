package com.ankamagames.dofus.network.messages.game.chat.channel;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChannelEnablingMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int channel = 0;
  public boolean enable = false;
  public static final int protocolId = 890;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.channel);
    param1.writeBoolean(this.enable);
  }

  public void deserialize(ICustomDataInput param1) {
    this.channel = param1.readByte();
    if (this.channel < 0) {
      throw new Error(
          "Forbidden value (" + this.channel + ") on element of ChatMessageReportMessage.channel.");
    }

    int _loc2_ = param1.readByte();
    if (_loc2_ < 0) {
      throw new Error("Forbidden value (" + _loc2_ + ") on elements of enable.");
    }
    this.enable.push(_loc2_);
  }
}
