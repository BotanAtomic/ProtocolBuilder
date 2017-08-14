package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextActorInformations extends Object implements INetworkType {

  public Number contextualId = 0;
  public EntityLook look;
  public EntityDispositionInformations disposition;
  private FuncTree _looktree;
  private FuncTree _dispositiontree;
  public static final int protocolId = 150;

  public void serialize(ICustomDataOutput param1) {
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.contextualId + ") on element contextualId.");
    }
    param1.writeDouble(this.contextualId);
    this.look.serializeAs_EntityLook(param1);
    param1.writeShort(this.disposition.getTypeId());
    this.disposition.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.contextualId = param1.readDouble();
    if (this.contextualId < -9.007199254740992E15 || this.contextualId > 9.007199254740992E15) {
      throw new Exception(
          "Forbidden value ("
              + this.contextualId
              + ") on element of GameContextActorInformations.contextualId.");
    }

    this.look = new EntityLook();
    this.look.deserialize(param1);
    int _loc2_ = param1.readUnsignedShort();
    this.disposition = ProtocolTypeManager.getInstance(EntityDispositionInformations, _loc2_);
    this.disposition.deserialize(param1);
  }
}
