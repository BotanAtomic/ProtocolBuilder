package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterTransferRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String uid = "";
  public static final int protocolId = 6349;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.uid);
  }

  public void deserialize(ICustomDataInput param1) {
    this.uid = param1.readUTF();
  }
}
