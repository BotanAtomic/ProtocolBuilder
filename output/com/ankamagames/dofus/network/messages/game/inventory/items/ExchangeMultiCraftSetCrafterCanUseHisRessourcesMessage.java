package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMultiCraftSetCrafterCanUseHisRessourcesMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean allow = false;
  public static final int protocolId = 6021;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.allow);
  }

  public void deserialize(ICustomDataInput param1) {
    this.allow = param1.readBoolean();
  }
}
