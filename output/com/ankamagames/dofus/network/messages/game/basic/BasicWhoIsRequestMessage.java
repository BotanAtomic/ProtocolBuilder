package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicWhoIsRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean verbose = false;
  public String search = "";
  public static final int protocolId = 181;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.verbose);
    param1.writeUTF(this.search);
  }

  public void deserialize(ICustomDataInput param1) {
    this.verbose = param1.readBoolean();

    this.search = param1.readUTF();
  }
}
