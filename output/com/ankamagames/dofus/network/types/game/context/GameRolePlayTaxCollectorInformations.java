package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.dofus.network.types.game.context.roleplay.GameRolePlayActorInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayTaxCollectorInformations extends GameRolePlayActorInformations
    implements INetworkType {

  public TaxCollectorStaticInformations identification;
  public int guildLevel = 0;
  public int taxCollectorAttack = 0;
  private FuncTree _identificationtree;
  public static final int protocolId = 148;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);

    param1.writeShort(this.identification.getTypeId());
    this.identification.serialize(param1);
    if (this.guildLevel < 0 || this.guildLevel > 255) {
      throw new Exception("Forbidden value (" + this.guildLevel + ") on element guildLevel.");
    }
    param1.writeByte(this.guildLevel);
    param1.writeInt(this.taxCollectorAttack);
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
    this.identification = ProtocolTypeManager.getInstance(TaxCollectorStaticInformations, _loc2_);
    this.identification.deserialize(param1);
    this.guildLevel = param1.readUnsignedByte();
    if (this.guildLevel < 1 || this.guildLevel > 200) {
      throw new Exception(
          "Forbidden value ("
              + this.guildLevel
              + ") on element of GuildVersatileInformations.guildLevel.");
    }

    this.taxCollectorAttack = param1.readInt();
  }
}
