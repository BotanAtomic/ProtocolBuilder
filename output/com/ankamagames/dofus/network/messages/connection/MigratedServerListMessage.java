package com.ankamagames.dofus.network.messages.connection;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MigratedServerListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> migratedServerIds;
  private FuncTree _migratedServerIdstree;
  public static final int protocolId = 6731;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.migratedServerIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.migratedServerIds.length) {
      if (this.migratedServerIds[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.migratedServerIds[_loc2_]
                + ") on element 1 (starting at 1) of migratedServerIds.");
      }
      param1.writeVarShort(this.migratedServerIds[_loc2_]);
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
        throw new Exception("Forbidden value (" + _loc4_ + ") on elements of migratedServerIds.");
      }
      this.migratedServerIds.push(_loc4_);
      _loc3_++;
    }
  }
}
