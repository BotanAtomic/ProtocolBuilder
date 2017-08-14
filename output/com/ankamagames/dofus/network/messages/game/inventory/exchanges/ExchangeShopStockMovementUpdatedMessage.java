package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemToSell;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeShopStockMovementUpdatedMessage extends NetworkMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public ObjectItemToSell objectInfo;
  private FuncTree _objectInfotree;
  public static final int protocolId = 5909;

  public void serialize(ICustomDataOutput param1) {
    this.objectInfo.serializeAs_ObjectItemToSell(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.objectInfo = new ObjectItemToSell();
    this.objectInfo.deserialize(param1);
  }
}
