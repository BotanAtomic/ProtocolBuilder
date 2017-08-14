package com.ankamagames.dofus.network.messages.game.atlas;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AtlasPointsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AtlasPointInformationsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public AtlasPointsInformations type;
  private FuncTree _typetree;
  public static final int protocolId = 5956;

  public void serialize(ICustomDataOutput param1) {
    this.type.serializeAs_AtlasPointsInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.type = new AtlasPointsInformations();
    this.type.deserialize(param1);
  }
}
