package com.ankamagames.dofus.network.messages.game.basic;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class BasicDateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int day = 0;
  public int month = 0;
  public int year = 0;
  public static final int protocolId = 177;

  public void serialize(ICustomDataOutput param1) {
    if (this.day < 0) {
      throw new Exception("Forbidden value (" + this.day + ") on element day.");
    }
    param1.writeByte(this.day);
    if (this.month < 0) {
      throw new Exception("Forbidden value (" + this.month + ") on element month.");
    }
    param1.writeByte(this.month);
    if (this.year < 0) {
      throw new Exception("Forbidden value (" + this.year + ") on element year.");
    }
    param1.writeShort(this.year);
  }

  public void deserialize(ICustomDataInput param1) {
    this.day = param1.readByte();
    if (this.day < 0) {
      throw new Exception("Forbidden value (" + this.day + ") on element of ObjectEffectDate.day.");
    }

    this.month = param1.readByte();
    if (this.month < 0) {
      throw new Exception(
          "Forbidden value (" + this.month + ") on element of ObjectEffectDate.month.");
    }

    this.year = param1.readVarUhShort();
    if (this.year < 0) {
      throw new Exception(
          "Forbidden value (" + this.year + ") on element of ObjectEffectDate.year.");
    }
  }
}
