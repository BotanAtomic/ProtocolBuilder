package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TextInformationMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int msgType = 0;
  public int msgId = 0;
  public Vector<String> parameters;
  private FuncTree _parameterstree;
  public static final int protocolId = 780;

  public void serialize(ICustomDataOutput param1) {
    param1.writeByte(this.msgType);
    if (this.msgId < 0) {
      throw new Exception("Forbidden value (" + this.msgId + ") on element msgId.");
    }
    param1.writeVarShort(this.msgId);
    param1.writeShort(this.parameters.length);
    int _loc2_ = 0;
    while (_loc2_ < this.parameters.length) {
      param1.writeUTF(this.parameters[_loc2_]);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    String _loc4_ = null;
    this.msgType = param1.readByte();
    if (this.msgType < 0) {
      throw new Exception(
          "Forbidden value (" + this.msgType + ") on element of TextInformationMessage.msgType.");
    }

    this.msgId = param1.readVarUhShort();
    if (this.msgId < 0) {
      throw new Exception(
          "Forbidden value (" + this.msgId + ") on element of SystemMessageDisplayMessage.msgId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUTF();
      this.parameters.push(_loc4_);
      _loc3_++;
    }
  }
}
