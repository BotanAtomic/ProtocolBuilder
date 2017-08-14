package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.context.GameContextActorInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightFighterInformations extends GameContextActorInformations
    implements INetworkType {

  public int teamId = 2;
  public int wave = 0;
  public boolean alive = false;
  public GameFightMinimalStats stats;
  public Vector<uint> previousPositions;
  private FuncTree _statstree;
  private FuncTree _previousPositionstree;
  public static final int protocolId = 143;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    param1.writeByte(this.teamId);
    if (this.wave < 0) {
      throw new Error("Forbidden value (" + this.wave + ") on element wave.");
    }
    param1.writeByte(this.wave);
    param1.writeBoolean(this.alive);
    param1.writeShort(this.stats.getTypeId());
    this.stats.serialize(param1);
    param1.writeShort(this.previousPositions.length);
    int _loc2_ = 0;
    while (_loc2_ < this.previousPositions.length) {
      if (this.previousPositions[_loc2_] < 0 || this.previousPositions[_loc2_] > 559) {
        throw new Error(
            "Forbidden value ("
                + this.previousPositions[_loc2_]
                + ") on element 5 (starting at 1) of previousPositions.");
      }
      param1.writeVarShort(this.previousPositions[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc5_ = 0;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.teamId = param1.readByte();
    if (this.teamId < 0) {
      throw new Error("Forbidden value (" + this.teamId + ") on element of NamedPartyTeam.teamId.");
    }

    this.wave = param1.readByte();
    if (this.wave < 0) {
      throw new Error(
          "Forbidden value ("
              + this.wave
              + ") on element of GameFightFighterLightInformations.wave.");
    }

    this.alive = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    this.stats = ProtocolTypeManager.getInstance(GameFightMinimalStats, _loc2_);
    this.stats.deserialize(param1);
    int _loc3_ = param1.readUnsignedShort();
    int _loc4_ = 0;
    while (_loc4_ < _loc3_) {
      _loc5_ = param1.readVarUhShort();
      if (_loc5_ < 0 || _loc5_ > 559) {
        throw new Error("Forbidden value (" + _loc5_ + ") on elements of previousPositions.");
      }
      this.previousPositions.push(_loc5_);
      _loc4_++;
    }
  }
}
