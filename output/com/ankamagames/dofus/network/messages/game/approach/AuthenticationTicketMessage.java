package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AuthenticationTicketMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String lang = "";
  public String ticket = "";
  public static final int protocolId = 110;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.lang);
    param1.writeUTF(this.ticket);
  }

  public void deserialize(ICustomDataInput param1) {
    this.lang = param1.readUTF();

    int _loc2_ = param1.readByte();
    this.ticket.push(_loc2_);
  }
}
