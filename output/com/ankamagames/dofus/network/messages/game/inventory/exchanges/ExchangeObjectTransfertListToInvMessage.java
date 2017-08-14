package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectTransfertListToInvMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> ids;
  private FuncTree _idstree;
  public static final int protocolId = 6039;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.ids.length);
    int _loc2_ = 0;
    while (_loc2_ < this.ids.length) {
      if (this.ids[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
      }
      param1.writeVarInt(this.ids[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhInt();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of ids.");
      }
      this.ids.push(_loc4_);
      _loc3_++;
    }
  }
}
