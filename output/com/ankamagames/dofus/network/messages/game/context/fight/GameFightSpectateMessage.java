package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.action.fight.FightDispellableEffectExtendedInformations;
import com.ankamagames.dofus.network.types.game.actions.fight.GameActionMark;
import com.ankamagames.dofus.network.types.game.idol.Idol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightSpectateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<FightDispellableEffectExtendedInformations> effects;
  public Vector<GameActionMark> marks;
  public int gameTurn = 0;
  public int fightStart = 0;
  public Vector<Idol> idols;
  private FuncTree _effectstree;
  private FuncTree _markstree;
  private FuncTree _idolstree;
  public static final int protocolId = 6069;

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
      throw new Error("Forbidden value (" + this.gameTurn + ") on element gameTurn.");
    }
    param1.writeVarShort(this.gameTurn);
    if (this.fightStart < 0) {
      throw new Error("Forbidden value (" + this.fightStart + ") on element fightStart.");
    }
    param1.writeInt(this.fightStart);
    param1.writeShort(this.idols.length);
    int _loc4_ = 0;
    while (_loc4_ < this.idols.length) {
      ((Idol) this.idols[_loc4_]).serializeAs_(param1);
      _loc4_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    FightDispellableEffectExtendedInformations _loc8_ = null;
    GameActionMark _loc9_ = null;
    Idol _loc10_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc8_ = new FightDispellableEffectExtendedInformations();
      _loc8_.deserialize(param1);
      this.effects.push(_loc8_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc9_ = new GameActionMark();
      _loc9_.deserialize(param1);
      this.marks.push(_loc9_);
      _loc5_++;
    }
    this.gameTurn = param1.readVarUhShort();
    if (this.gameTurn < 0) {
      throw new Error(
          "Forbidden value ("
              + this.gameTurn
              + ") on element of GameFightSpectateMessage.gameTurn.");
    }

    this.fightStart = param1.readInt();
    if (this.fightStart < 0) {
      throw new Error(
          "Forbidden value ("
              + this.fightStart
              + ") on element of FightExternalInformations.fightStart.");
    }

    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc10_ = new Idol();
      _loc10_.deserialize(param1);
      this.idols.push(_loc10_);
      _loc7_++;
    }
  }
}
