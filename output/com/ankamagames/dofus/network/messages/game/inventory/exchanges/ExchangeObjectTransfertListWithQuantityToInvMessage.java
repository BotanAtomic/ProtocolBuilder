package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeObjectTransfertListWithQuantityToInvMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> ids;
  public Vector<uint> qtys;
  private FuncTree _idstree;
  private FuncTree _qtystree;
  public static final int protocolId = 6470;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.ids.length);
    int _loc2_ = 0;
    while (_loc2_ < this.ids.length) {
      if (this.ids[_loc2_] < 0) {
        throw new Error(
            "Forbidden value (" + this.ids[_loc2_] + ") on element 1 (starting at 1) of ids.");
      }
      param1.writeVarInt(this.ids[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.qtys.length);
    int _loc3_ = 0;
    while (_loc3_ < this.qtys.length) {
      if (this.qtys[_loc3_] < 0) {
        throw new Error(
            "Forbidden value (" + this.qtys[_loc3_] + ") on element 2 (starting at 1) of qtys.");
      }
      param1.writeVarInt(this.qtys[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readVarUhInt();
      if (_loc6_ < 0) {
        throw new Error("Forbidden value (" + _loc6_ + ") on elements of ids.");
      }
      this.ids.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readVarUhInt();
      if (_loc7_ < 0) {
        throw new Error("Forbidden value (" + _loc7_ + ") on elements of qtys.");
      }
      this.qtys.push(_loc7_);
      _loc5_++;
    }
  }
}
