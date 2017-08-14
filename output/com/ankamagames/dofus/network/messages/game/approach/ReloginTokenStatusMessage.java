package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ReloginTokenStatusMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean validToken = false;
  public Vector<Integer> ticket;
  private FuncTree _tickettree;
  public static final int protocolId = 6539;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.validToken);
    param1.writeVarInt(this.ticket.length);
    int _loc2_ = 0;
    while (_loc2_ < this.ticket.length) {
      param1.writeByte(this.ticket[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.validToken = param1.readBoolean();

    int _loc2_ = param1.readVarInt();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readByte();
      this.ticket.push(_loc4_);
      _loc3_++;
    }
  }
}
