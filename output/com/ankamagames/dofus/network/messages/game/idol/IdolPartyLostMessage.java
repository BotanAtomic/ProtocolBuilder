package com.ankamagames.dofus.network.messages.game.idol;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IdolPartyLostMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int idolId = 0;
  public static final int protocolId = 6580;

  public void serialize(ICustomDataOutput param1) {
    if (this.idolId < 0) {
      throw new Exception("Forbidden value (" + this.idolId + ") on element idolId.");
    }
    param1.writeVarShort(this.idolId);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readVarUhShort();
    if (_loc2_ < 0) {
      throw new Exception("Forbidden value (" + _loc2_ + ") on elements of idolId.");
    }
    this.idolId.push(_loc2_);
  }
}
