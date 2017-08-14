package com.ankamagames.dofus.network.messages.connection.search;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AcquaintanceServerListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> servers;
  private FuncTree _serverstree;
  public static final int protocolId = 6142;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.servers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.servers.length) {
      if (this.servers[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.servers[_loc2_]
                + ") on element 1 (starting at 1) of servers.");
      }
      param1.writeVarShort(this.servers[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readVarUhShort();
      if (_loc4_ < 0) {
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of servers.");
      }
      this.servers.push(_loc4_);
      _loc3_++;
    }
  }
}
