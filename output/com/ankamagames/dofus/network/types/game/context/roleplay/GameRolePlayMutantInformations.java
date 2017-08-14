package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayMutantInformations extends GameRolePlayHumanoidInformations
    implements INetworkType {

  public int monsterId = 0;
  public int powerLevel = 0;
  public static final int protocolId = 3;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    param1.writeUTF(this.name);

    param1.writeShort(this.humanoidInfo.getTypeId());
    this.humanoidInfo.serialize(param1);
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);

    if (this.monsterId < 0) {
      throw new Error("Forbidden value (" + this.monsterId + ") on element monsterId.");
    }
    param1.writeVarShort(this.monsterId);
    param1.writeByte(this.powerLevel);
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

    this.monsterId = param1.readVarUhShort();
    if (this.monsterId < 0) {
      throw new Error(
          "Forbidden value (" + this.monsterId + ") on element of DareReward.monsterId.");
    }

    this.powerLevel = param1.readByte();
  }
}
