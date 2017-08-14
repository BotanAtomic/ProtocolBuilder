package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class GameFightJoinMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean isTeamPhase = false;
  public boolean canBeCancelled = false;
  public boolean canSayReady = false;
  public boolean isFightStarted = false;
  public int timeMaxBeforeFightStart = 0;
  public int fightType = 0;
  public static final int protocolId = 702;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.isTeamPhase);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.canBeCancelled);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.canSayReady);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 3, this.isFightStarted);
    param1.writeByte(_loc2_);
    if (this.timeMaxBeforeFightStart < 0) {
      throw new Error(
          "Forbidden value ("
              + this.timeMaxBeforeFightStart
              + ") on element timeMaxBeforeFightStart.");
    }
    param1.writeShort(this.timeMaxBeforeFightStart);
    param1.writeByte(this.fightType);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.timeMaxBeforeFightStart = param1.readShort();
    if (this.timeMaxBeforeFightStart < 0) {
      throw new Error(
          "Forbidden value ("
              + this.timeMaxBeforeFightStart
              + ") on element of GameFightJoinMessage.timeMaxBeforeFightStart.");
    }

    this.fightType = param1.readByte();
    if (this.fightType < 0) {
      throw new Error(
          "Forbidden value ("
              + this.fightType
              + ") on element of FightExternalInformations.fightType.");
    }
  }
}
