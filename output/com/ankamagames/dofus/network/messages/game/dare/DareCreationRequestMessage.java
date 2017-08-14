package com.ankamagames.dofus.network.messages.game.dare;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.dare.DareCriteria;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;

public class DareCreationRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number subscriptionFee = 0;
  public Number jackpot = 0;
  public int maxCountWinners = 0;
  public int delayBeforeStart = 0;
  public int duration = 0;
  public boolean isPrivate = false;
  public boolean isForGuild = false;
  public boolean isForAlliance = false;
  public boolean needNotifications = false;
  public Vector<DareCriteria> criterions;
  private FuncTree _criterionstree;
  public static final int protocolId = 6665;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.isPrivate);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.isForGuild);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.isForAlliance);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 3, this.needNotifications);
    param1.writeByte(_loc2_);
    if (this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.subscriptionFee + ") on element subscriptionFee.");
    }
    param1.writeVarLong(this.subscriptionFee);
    if (this.jackpot < 0 || this.jackpot > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.jackpot + ") on element jackpot.");
    }
    param1.writeVarLong(this.jackpot);
    if (this.maxCountWinners < 0 || this.maxCountWinners > 65535) {
      throw new Error("Forbidden value (" + this.maxCountWinners + ") on element maxCountWinners.");
    }
    param1.writeShort(this.maxCountWinners);
    if (this.delayBeforeStart < 0 || this.delayBeforeStart > 4.294967295E9) {
      throw new Error(
          "Forbidden value (" + this.delayBeforeStart + ") on element delayBeforeStart.");
    }
    param1.writeUnsignedInt(this.delayBeforeStart);
    if (this.duration < 0 || this.duration > 4.294967295E9) {
      throw new Error("Forbidden value (" + this.duration + ") on element duration.");
    }
    param1.writeUnsignedInt(this.duration);
    param1.writeShort(this.criterions.length);
    int _loc3_ = 0;
    while (_loc3_ < this.criterions.length) {
      ((DareCriteria) this.criterions[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    DareCriteria _loc4_ = null;
    int _loc2_ = param1.readByte();
    this.sex = BooleanByteWrapper.getFlag(_loc2_, 0);
    this.isRideable = BooleanByteWrapper.getFlag(_loc2_, 1);
    this.isWild = BooleanByteWrapper.getFlag(_loc2_, 2);
    this.isFecondationReady = BooleanByteWrapper.getFlag(_loc2_, 3);
    this.useHarnessColors = BooleanByteWrapper.getFlag(_loc2_, 4);

    this.subscriptionFee = param1.readVarUhLong();
    if (this.subscriptionFee < 0 || this.subscriptionFee > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.subscriptionFee
              + ") on element of DareInformations.subscriptionFee.");
    }

    this.jackpot = param1.readVarUhLong();
    if (this.jackpot < 0 || this.jackpot > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.jackpot + ") on element of DareInformations.jackpot.");
    }

    this.maxCountWinners = param1.readUnsignedShort();
    if (this.maxCountWinners < 0 || this.maxCountWinners > 65535) {
      throw new Error(
          "Forbidden value ("
              + this.maxCountWinners
              + ") on element of DareInformations.maxCountWinners.");
    }

    this.delayBeforeStart = param1.readUnsignedInt();
    if (this.delayBeforeStart < 0 || this.delayBeforeStart > 4.294967295E9) {
      throw new Error(
          "Forbidden value ("
              + this.delayBeforeStart
              + ") on element of DareCreationRequestMessage.delayBeforeStart.");
    }

    this.duration = param1.readVarUhShort();
    if (this.duration < 0) {
      throw new Error(
          "Forbidden value (" + this.duration + ") on element of InteractiveUsedMessage.duration.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new DareCriteria();
      _loc4_.deserialize(param1);
      this.criterions.push(_loc4_);
      _loc3_++;
    }
  }
}
