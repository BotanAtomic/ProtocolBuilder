package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayHumanoidInformations extends GameRolePlayNamedActorInformations
    implements INetworkType {

  public HumanInformations humanoidInfo;
  public int accountId = 0;
  private FuncTree _humanoidInfotree;
  public static final int protocolId = 159;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    param1.writeUTF(this.name);

    param1.writeShort(this.humanoidInfo.getTypeId());
    this.humanoidInfo.serialize(param1);
    if (this.accountId < 0) {
      throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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
    this.humanoidInfo = ProtocolTypeManager.getInstance(HumanInformations, _loc2_);
    this.humanoidInfo.deserialize(param1);
    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Exception(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }
  }
}
