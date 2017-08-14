package com.ankamagames.dofus.network.messages.game.chat;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatAbstractClientMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String content = "";
  public static final int protocolId = 850;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.content);
  }

  public void deserialize(ICustomDataInput param1) {
    this.content = param1.readUTF();
  }
}
