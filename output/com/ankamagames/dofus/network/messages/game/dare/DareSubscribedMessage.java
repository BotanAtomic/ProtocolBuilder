package com.ankamagames.dofus.network.messages.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class DareSubscribedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number dareId = 0;
  public boolean success = false;
  public boolean subscribe = false;
  public DareVersatileInformations dareVersatilesInfos;
  private FuncTree _dareVersatilesInfostree;
  public static final int protocolId = 6660;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.success);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.subscribe);
    param1.writeByte(_loc2_);
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.dareId + ") on element dareId.");
    }
    param1.writeDouble(this.dareId);
    this.dareVersatilesInfos.serializeAs_DareVersatileInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.dareId = param1.readDouble();
    if (this.dareId < 0 || this.dareId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value (" + this.dareId + ") on element of DareVersatileInformations.dareId.");
    }

    this.dareVersatilesInfos = new DareVersatileInformations();
    this.dareVersatilesInfos.deserialize(param1);
  }
}
