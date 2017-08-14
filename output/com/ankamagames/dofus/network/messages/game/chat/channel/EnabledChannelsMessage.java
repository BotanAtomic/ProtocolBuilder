package com.ankamagames.dofus.network.messages.game.chat.channel;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EnabledChannelsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> channels;
  public Vector<uint> disallowed;
  private FuncTree _channelstree;
  private FuncTree _disallowedtree;
  public static final int protocolId = 892;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.channels.length);
    int _loc2_ = 0;
    while (_loc2_ < this.channels.length) {
      param1.writeByte(this.channels[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.disallowed.length);
    int _loc3_ = 0;
    while (_loc3_ < this.disallowed.length) {
      param1.writeByte(this.disallowed[_loc3_]);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    int _loc7_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readByte();
      if (_loc6_ < 0) {
        throw new Exception("Forbidden value (" + _loc6_ + ") on elements of channels.");
      }
      this.channels.push(_loc6_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc7_ = param1.readByte();
      if (_loc7_ < 0) {
        throw new Exception("Forbidden value (" + _loc7_ + ") on elements of disallowed.");
      }
      this.disallowed.push(_loc7_);
      _loc5_++;
    }
  }
}
