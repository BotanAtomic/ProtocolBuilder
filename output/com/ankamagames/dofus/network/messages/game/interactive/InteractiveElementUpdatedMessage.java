package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveElementUpdatedMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public InteractiveElement interactiveElement;
  private FuncTree _interactiveElementtree;
  public static final int protocolId = 5708;

  public void serialize(ICustomDataOutput param1) {
    this.interactiveElement.serializeAs_InteractiveElement(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.interactiveElement = new InteractiveElement();
    this.interactiveElement.deserialize(param1);
  }
}
