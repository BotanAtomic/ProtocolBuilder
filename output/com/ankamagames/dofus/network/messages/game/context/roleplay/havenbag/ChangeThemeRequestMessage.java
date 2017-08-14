package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChangeThemeRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int theme = 0;
  public static final int protocolId = 6639;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.theme);
  }

  public void deserialize(ICustomDataInput param1) {
    this.theme = param1.readByte();
  }
}
