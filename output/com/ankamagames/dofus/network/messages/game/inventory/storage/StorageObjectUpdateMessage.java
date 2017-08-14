package com.ankamagames.dofus.network.messages.game.inventory.storage;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StorageObjectUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public ObjectItem object;
  private FuncTree _objecttree;
  public static final int protocolId = 5647;

  public void serialize(ICustomDataOutput param1) {
    this.object.serializeAs_ObjectItem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.object = new ObjectItem();
    this.object.deserialize(param1);
  }
}
