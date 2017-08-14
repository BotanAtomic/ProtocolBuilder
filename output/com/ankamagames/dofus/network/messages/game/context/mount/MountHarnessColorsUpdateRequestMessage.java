package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountHarnessColorsUpdateRequestMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean useHarnessColors = false;
  public static final int protocolId = 6697;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.useHarnessColors);
  }

  public void deserialize(ICustomDataInput param1) {
    this.useHarnessColors = param1.readBoolean();
  }
}
