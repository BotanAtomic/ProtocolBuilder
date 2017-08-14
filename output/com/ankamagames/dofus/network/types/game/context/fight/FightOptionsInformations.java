package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class FightOptionsInformations extends Object implements INetworkType {

  public boolean isSecret = false;
  public boolean isRestrictedToPartyOnly = false;
  public boolean isClosed = false;
  public boolean isAskingForHelp = false;
  public static final int protocolId = 20;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.isSecret);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.isRestrictedToPartyOnly);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.isClosed);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 3, this.isAskingForHelp);
    param1.writeByte(_loc2_);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);
  }
}
