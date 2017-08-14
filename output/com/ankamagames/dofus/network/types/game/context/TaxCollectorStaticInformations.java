package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TaxCollectorStaticInformations extends Object implements INetworkType {

  public int firstNameId = 0;
  public int lastNameId = 0;
  public GuildInformations guildIdentity;
  private FuncTree _guildIdentitytree;
  public static final int protocolId = 147;

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
  }

  public void deserialize(ICustomDataInput param1) {
    this.firstNameId = param1.readVarUhShort();
    if (this.firstNameId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.firstNameId
              + ") on element of TaxCollectorBasicInformations.firstNameId.");
    }

    this.lastNameId = param1.readVarUhShort();
    if (this.lastNameId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.lastNameId
              + ") on element of TaxCollectorInformations.lastNameId.");
    }

    this.guildIdentity = new GuildInformations();
    this.guildIdentity.deserialize(param1);
  }
}
