package com.ankamagames.dofus.network.types.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.character.alignment.ActorAlignmentInformations;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightCharacterInformations extends GameFightFighterNamedInformations
    implements INetworkType {

  public int level = 0;
  public ActorAlignmentInformations alignmentInfos;
  public int breed = 0;
  public boolean sex = false;
  private FuncTree _alignmentInfostree;
  public static final int protocolId = 46;

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

    param1.writeUTF(this.name);
    this.status.serializeAs_PlayerStatus(param1);

    if (this.level < 0 || this.level > 255) {
      throw new Error("Forbidden value (" + this.level + ") on element level.");
    }
    param1.writeByte(this.level);
    this.alignmentInfos.serializeAs_ActorAlignmentInformations(param1);
    param1.writeByte(this.breed);
    param1.writeBoolean(this.sex);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    this.level = param1.readByte();
    if (this.level < 0) {
      throw new Error("Forbidden value (" + this.level + ") on element of MountClientData.level.");
    }

    this.alignmentInfos = new ActorAlignmentInformations();
    this.alignmentInfos.deserialize(param1);
    this.breed = param1.readByte();

    this.sex = param1.readBoolean();
  }
}
