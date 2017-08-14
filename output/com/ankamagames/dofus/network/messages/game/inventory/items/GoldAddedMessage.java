package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.GoldItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GoldAddedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public GoldItem gold;
  private FuncTree _goldtree;
  public static final int protocolId = 6030;

  public void serialize(ICustomDataOutput param1) {
    this.gold.serializeAs_GoldItem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.gold = new GoldItem();
    this.gold.deserialize(param1);
  }
}
