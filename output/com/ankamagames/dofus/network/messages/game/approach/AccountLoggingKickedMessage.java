package com.ankamagames.dofus.network.messages.game.approach;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AccountLoggingKickedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int days = 0;
  public int hours = 0;
  public int minutes = 0;
  public static final int protocolId = 6029;

  public void serialize(ICustomDataOutput param1) {
    if (this.days < 0) {
      throw new Error("Forbidden value (" + this.days + ") on element days.");
    }
    param1.writeVarShort(this.days);
    if (this.hours < 0) {
      throw new Error("Forbidden value (" + this.hours + ") on element hours.");
    }
    param1.writeByte(this.hours);
    if (this.minutes < 0) {
      throw new Error("Forbidden value (" + this.minutes + ") on element minutes.");
    }
    param1.writeByte(this.minutes);
  }

  public void deserialize(ICustomDataInput param1) {
    this.days = param1.readVarUhShort();
    if (this.days < 0) {
      throw new Error(
          "Forbidden value (" + this.days + ") on element of ObjectEffectDuration.days.");
    }

    this.hours = param1.readByte();
    if (this.hours < 0) {
      throw new Error(
          "Forbidden value (" + this.hours + ") on element of ObjectEffectDuration.hours.");
    }

    this.minutes = param1.readByte();
    if (this.minutes < 0) {
      throw new Error(
          "Forbidden value (" + this.minutes + ") on element of ObjectEffectDuration.minutes.");
    }
  }
}
