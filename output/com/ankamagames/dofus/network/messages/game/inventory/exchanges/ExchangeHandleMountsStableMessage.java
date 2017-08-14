package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeHandleMountsStableMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int actionType = 0;
  public Vector<uint> ridesId;
  private FuncTree _ridesIdtree;
  public static final int protocolId = 6562;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.actionType);
    param1.writeShort(this.ridesId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.ridesId.length) {
      if (this.ridesId[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.ridesId[_loc2_]
                + ") on element 2 (starting at 1) of ridesId.");
      }
      param1.writeVarInt(this.ridesId[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    this.actionType = param1.readByte();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhInt();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of ridesId.");
      }
      this.ridesId.push(_loc4_);
      _loc3_++;
    }
  }
}
