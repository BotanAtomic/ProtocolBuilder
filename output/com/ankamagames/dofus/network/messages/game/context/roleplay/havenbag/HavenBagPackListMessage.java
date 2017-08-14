package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HavenBagPackListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<Integer> packIds;
  private FuncTree _packIdstree;
  public static final int protocolId = 6620;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.packIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.packIds.length) {
      param1.writeByte(this.packIds[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readByte();
      this.packIds.push(_loc4_);
      _loc3_++;
    }
  }
}
