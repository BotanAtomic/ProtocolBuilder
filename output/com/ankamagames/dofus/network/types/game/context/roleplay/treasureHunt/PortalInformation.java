package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PortalInformation extends Object implements INetworkType {

  public int portalId = 0;
  public int areaId = 0;
  public static final int protocolId = 466;

  public void serialize(ICustomDataOutput param1) {
    param1.writeInt(this.portalId);
    param1.writeShort(this.areaId);
  }

  public void deserialize(ICustomDataInput param1) {
    this.portalId = param1.readInt();

    this.areaId = param1.readShort();
  }
}
