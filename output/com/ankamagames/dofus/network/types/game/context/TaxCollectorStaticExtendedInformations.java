package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorStaticExtendedInformations extends TaxCollectorStaticInformations
    implements INetworkType {

  public AllianceInformations allianceIdentity;
  private FuncTree _allianceIdentitytree;
  public static final int protocolId = 440;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.firstNameId < 0) {
      throw new Exception("Forbidden value (" + this.firstNameId + ") on element firstNameId.");
    }
    param1.writeVarShort(this.firstNameId);
    if (this.lastNameId < 0) {
      throw new Exception("Forbidden value (" + this.lastNameId + ") on element lastNameId.");
    }
    param1.writeVarShort(this.lastNameId);
    this.guildIdentity.serializeAs_GuildInformations(param1);

    this.allianceIdentity.serializeAs_AllianceInformations(param1);
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

    this.allianceIdentity = new AllianceInformations();
    this.allianceIdentity.deserialize(param1);
  }
}
