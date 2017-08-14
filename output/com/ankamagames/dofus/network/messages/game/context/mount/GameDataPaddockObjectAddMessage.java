package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.paddock.PaddockItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameDataPaddockObjectAddMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public PaddockItem paddockItemDescription;
  private FuncTree _paddockItemDescriptiontree;
  public static final int protocolId = 5990;

  public void serialize(ICustomDataOutput param1) {
    this.paddockItemDescription.serializeAs_PaddockItem(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.paddockItemDescription = new PaddockItem();
    this.paddockItemDescription.deserialize(param1);
  }
}
