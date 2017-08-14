package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.startup.StartupActionAddObject;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StartupActionAddMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public StartupActionAddObject newAction;
  private FuncTree _newActiontree;
  public static final int protocolId = 6538;

  public void serialize(ICustomDataOutput param1) {
    this.newAction.serializeAs_StartupActionAddObject(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.newAction = new StartupActionAddObject();
    this.newAction.deserialize(param1);
  }
}
