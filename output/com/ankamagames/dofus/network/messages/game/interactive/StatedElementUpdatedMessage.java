package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatedElementUpdatedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public StatedElement statedElement;
  private FuncTree _statedElementtree;
  public static final int protocolId = 5709;

  public void serialize(ICustomDataOutput param1) {
    this.statedElement.serializeAs_StatedElement(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.statedElement = new StatedElement();
    this.statedElement.deserialize(param1);
  }
}
