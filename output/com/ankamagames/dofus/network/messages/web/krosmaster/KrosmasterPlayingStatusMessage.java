package com.ankamagames.dofus.network.messages.web.krosmaster;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class KrosmasterPlayingStatusMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean playing = false;
  public static final int protocolId = 6347;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.playing);
  }

  public void deserialize(ICustomDataInput param1) {
    this.playing = param1.readBoolean();
  }
}
