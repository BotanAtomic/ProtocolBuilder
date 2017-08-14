package com.ankamagames.dofus.network.messages.web.ankabox;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class NewMailMessage extends MailStatusMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> sendersAccountId;
  private FuncTree _sendersAccountIdtree;
  public static final int protocolId = 6292;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.unread < 0) {
      throw new Error("Forbidden value (" + this.unread + ") on element unread.");
    }
    param1.writeVarShort(this.unread);
    if (this.total < 0) {
      throw new Error("Forbidden value (" + this.total + ") on element total.");
    }
    param1.writeVarShort(this.total);

    param1.writeShort(this.sendersAccountId.length);
    int _loc2_ = 0;
    while (_loc2_ < this.sendersAccountId.length) {
      if (this.sendersAccountId[_loc2_] < 0) {
        throw new Error(
            "Forbidden value ("
                + this.sendersAccountId[_loc2_]
                + ") on element 1 (starting at 1) of sendersAccountId.");
      }
      param1.writeInt(this.sendersAccountId[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readInt();
      if (_loc4_ < 0) {
        throw new Error("Forbidden value (" + _loc4_ + ") on elements of sendersAccountId.");
      }
      this.sendersAccountId.push(_loc4_);
      _loc3_++;
    }
  }
}
