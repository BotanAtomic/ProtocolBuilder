package com.ankamagames.dofus.network.messages.game.idol;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class IdolSelectErrorMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int reason = 0;
  public int idolId = 0;
  public boolean activate = false;
  public boolean party = false;
  public static final int protocolId = 6584;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.activate);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.party);
    param1.writeByte(_loc2_);
    param1.writeByte(this.reason);
    if (this.idolId < 0) {
      throw new Error("Forbidden value (" + this.idolId + ") on element idolId.");
    }
    param1.writeVarShort(this.idolId);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.reason = param1.readByte();
    if (this.reason < 0) {
      throw new Error(
          "Forbidden value ("
              + this.reason
              + ") on element of KrosmasterInventoryErrorMessage.reason.");
    }

    int _loc2_ = param1.readVarUhShort();
    if (_loc2_ < 0) {
      throw new Error("Forbidden value (" + _loc2_ + ") on elements of idolId.");
    }
    this.idolId.push(_loc2_);
  }
}
