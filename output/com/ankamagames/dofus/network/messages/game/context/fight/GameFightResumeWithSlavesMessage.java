package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightResumeSlaveInfo;
import com.ankamagames.dofus.network.types.game.action.fight.FightDispellableEffectExtendedInformations;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightSpellCooldown;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightResumeWithSlavesMessage extends GameFightResumeMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<GameFightResumeSlaveInfo> slavesInfo;
  private FuncTree _slavesInfotree;
  public static final int protocolId = 6215;

  @Override
  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.effects.length);
    int _loc2_ = 0;
    while (_loc2_ < this.effects.length) {
      ((FightDispellableEffectExtendedInformations) this.effects[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    param1.writeShort(this.marks.length);
    int _loc3_ = 0;
    while (_loc3_ < this.marks.length) {
      ((GameActionMark) this.marks[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
    if (this.gameTurn < 0) {
      throw new Exception("Forbidden value (" + this.gameTurn + ") on element gameTurn.");
    }
    param1.writeVarShort(this.gameTurn);
    if (this.fightStart < 0) {
      throw new Exception("Forbidden value (" + this.fightStart + ") on element fightStart.");
    }
    param1.writeInt(this.fightStart);
    param1.writeShort(this.idols.length);
    int _loc4_ = 0;
    while (_loc4_ < this.idols.length) {
      ((Idol) this.idols[_loc4_]).serializeAs_(param1);
      _loc4_++;
    }

    param1.writeShort(this.spellCooldowns.length);
    int _loc2_ = 0;
    while (_loc2_ < this.spellCooldowns.length) {
      ((GameFightSpellCooldown) this.spellCooldowns[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
    if (this.summonCount < 0) {
      throw new Exception("Forbidden value (" + this.summonCount + ") on element summonCount.");
    }
    param1.writeByte(this.summonCount);
    if (this.bombCount < 0) {
      throw new Exception("Forbidden value (" + this.bombCount + ") on element bombCount.");
    }
    param1.writeByte(this.bombCount);

    param1.writeShort(this.slavesInfo.length);
    int _loc2_ = 0;
    while (_loc2_ < this.slavesInfo.length) {
      ((GameFightResumeSlaveInfo) this.slavesInfo[_loc2_]).serializeAs_(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    GameFightResumeSlaveInfo _loc4_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = new GameFightResumeSlaveInfo();
      _loc4_.deserialize(param1);
      this.slavesInfo.push(_loc4_);
      _loc3_++;
    }
  }
}
