package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HelloConnectMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public String salt = "";
  public Vector<Integer> key;
  private FuncTree _keytree;
  public static final int protocolId = 3;

  public void serialize(ICustomDataOutput param1) {
    param1.writeUTF(this.salt);
    param1.writeVarInt(this.key.length);
    int _loc2_ = 0;
    while (_loc2_ < this.key.length) {
      param1.writeByte(this.key[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.salt = param1.readUTF();

    int _loc2_ = param1.readVarInt();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readByte();
      this.key.push(_loc4_);
      _loc3_++;
    }
  }
}
