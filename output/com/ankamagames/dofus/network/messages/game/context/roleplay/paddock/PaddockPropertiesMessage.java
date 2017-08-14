package com.ankamagames.dofus.network.messages.game.context.roleplay.paddock;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockInstancesInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PaddockPropertiesMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public PaddockInstancesInformations properties;
  private FuncTree _propertiestree;
  public static final int protocolId = 5824;

  public void serialize(ICustomDataOutput param1) {
    this.properties.serializeAs_PaddockInstancesInformations(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.properties = new PaddockInstancesInformations();
    this.properties.deserialize(param1);
  }
}
