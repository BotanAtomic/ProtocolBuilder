package com.ankamagames.dofus.network.messages.game.startup;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class StartupActionFinishedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean success = false;
  public int actionId = 0;
  public boolean automaticAction = false;
  public static final int protocolId = 1304;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.success);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.automaticAction);
    param1.writeByte(_loc2_);
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeInt(this.actionId);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.actionId = param1.readVarUhShort();
    if (this.actionId < 0) {
      throw new Error(
          "Forbidden value (" + this.actionId + ") on element of ObjectEffect.actionId.");
    }
  }
}
