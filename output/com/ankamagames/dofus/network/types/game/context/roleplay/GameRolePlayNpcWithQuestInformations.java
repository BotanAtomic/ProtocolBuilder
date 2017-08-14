package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.GameRolePlayNpcQuestFlag;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayNpcWithQuestInformations extends GameRolePlayNpcInformations
    implements INetworkType {

  public GameRolePlayNpcQuestFlag questFlag;
  private FuncTree _questFlagtree;
  public static final int protocolId = 383;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    if (this.npcId < 0) {
      throw new Error("Forbidden value (" + this.npcId + ") on element npcId.");
    }
    param1.writeVarShort(this.npcId);
    param1.writeBoolean(this.sex);
    if (this.specialArtworkId < 0) {
      throw new Error(
          "Forbidden value (" + this.specialArtworkId + ") on element specialArtworkId.");
    }
    param1.writeVarShort(this.specialArtworkId);

    this.questFlag.serializeAs_GameRolePlayNpcQuestFlag(param1);
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

    this.questFlag = new GameRolePlayNpcQuestFlag();
    this.questFlag.deserialize(param1);
  }
}
