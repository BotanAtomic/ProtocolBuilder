package com.ankamagames.dofus.network.messages.game.context.notification;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NotificationByServerMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int id = 0;
  public Vector<String> parameters;
  public boolean forceOpen = false;
  private FuncTree _parameterstree;
  public static final int protocolId = 6103;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarShort(this.id);
    param1.writeShort(this.parameters.length);
    int _loc2_ = 0;
    while (_loc2_ < this.parameters.length) {
      param1.writeUTF(this.parameters[_loc2_]);
      _loc2_++;
    }
    param1.writeBoolean(this.forceOpen);
  }

  public void deserialize(ICustomDataInput param1) {
    String _loc4_ = null;
    this.id = param1.readUTF();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUTF();
      this.parameters.push(_loc4_);
      _loc3_++;
    }
    this.forceOpen = param1.readBoolean();
  }
}
