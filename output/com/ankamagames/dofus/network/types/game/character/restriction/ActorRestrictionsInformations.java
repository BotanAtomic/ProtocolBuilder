package com.ankamagames.dofus.network.types.game.character.restriction;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ActorRestrictionsInformations extends Object implements INetworkType {

  public boolean cantBeAggressed = false;
  public boolean cantBeChallenged = false;
  public boolean cantTrade = false;
  public boolean cantBeAttackedByMutant = false;
  public boolean cantRun = false;
  public boolean forceSlowWalk = false;
  public boolean cantMinimize = false;
  public boolean cantMove = false;
  public boolean cantAggress = false;
  public boolean cantChallenge = false;
  public boolean cantExchange = false;
  public boolean cantAttack = false;
  public boolean cantChat = false;
  public boolean cantBeMerchant = false;
  public boolean cantUseObject = false;
  public boolean cantUseTaxCollector = false;
  public boolean cantUseInteractive = false;
  public boolean cantSpeakToNPC = false;
  public boolean cantChangeZone = false;
  public boolean cantAttackMonster = false;
  public boolean cantWalk8Directions = false;
  public static final int protocolId = 204;

  public void serialize(ICustomDataOutput param1) {
    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.cantBeAggressed);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.cantBeChallenged);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 2, this.cantTrade);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 3, this.cantBeAttackedByMutant);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 4, this.cantRun);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 5, this.forceSlowWalk);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 6, this.cantMinimize);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 7, this.cantMove);
    param1.writeByte(_loc2_);
    int _loc3_ = 0;
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 0, this.cantAggress);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 1, this.cantChallenge);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 2, this.cantExchange);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 3, this.cantAttack);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 4, this.cantChat);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 5, this.cantBeMerchant);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 6, this.cantUseObject);
    _loc3_ = BooleanByteWrapper.setFlag(_loc3_, 7, this.cantUseTaxCollector);
    param1.writeByte(_loc3_);
    int _loc4_ = 0;
    _loc4_ = BooleanByteWrapper.setFlag(_loc4_, 0, this.cantUseInteractive);
    _loc4_ = BooleanByteWrapper.setFlag(_loc4_, 1, this.cantSpeakToNPC);
    _loc4_ = BooleanByteWrapper.setFlag(_loc4_, 2, this.cantChangeZone);
    _loc4_ = BooleanByteWrapper.setFlag(_loc4_, 3, this.cantAttackMonster);
    _loc4_ = BooleanByteWrapper.setFlag(_loc4_, 4, this.cantWalk8Directions);
    param1.writeByte(_loc4_);
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
