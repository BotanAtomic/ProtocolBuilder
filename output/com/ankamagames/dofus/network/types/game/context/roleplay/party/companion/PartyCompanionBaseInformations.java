package com.ankamagames.dofus.network.types.game.context.roleplay.party.companion;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyCompanionBaseInformations extends Object implements INetworkType {

  public int indexId = 0;
  public int companionGenericId = 0;
  public EntityLook entityLook;
  private FuncTree _entityLooktree;
  public static final int protocolId = 453;

  public void serialize(ICustomDataOutput param1) {
    if (this.indexId < 0) {
      throw new Exception("Forbidden value (" + this.indexId + ") on element indexId.");
    }
    param1.writeByte(this.indexId);
    if (this.companionGenericId < 0) {
      throw new Exception(
          "Forbidden value (" + this.companionGenericId + ") on element companionGenericId.");
    }
    param1.writeByte(this.companionGenericId);
    this.entityLook.serializeAs_EntityLook(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.indexId = param1.readByte();
    if (this.indexId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.indexId
              + ") on element of PartyCompanionBaseInformations.indexId.");
    }

    this.companionGenericId = param1.readByte();
    if (this.companionGenericId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.companionGenericId
              + ") on element of PartyCompanionBaseInformations.companionGenericId.");
    }

    this.entityLook = new EntityLook();
    this.entityLook.deserialize(param1);
  }
}
