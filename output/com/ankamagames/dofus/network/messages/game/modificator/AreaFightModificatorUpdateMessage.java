package com.ankamagames.dofus.network.messages.game.modificator;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AreaFightModificatorUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellPairId = 0;
  public static final int protocolId = 6493;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.spellPairId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.spellPairId = param1.readInt();
  }
}
