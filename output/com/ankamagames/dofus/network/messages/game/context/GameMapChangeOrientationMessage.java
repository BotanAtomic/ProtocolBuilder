package com.ankamagames.dofus.network.messages.game.context;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.ActorOrientation;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameMapChangeOrientationMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public ActorOrientation orientation;
  private FuncTree _orientationtree;
  public static final int protocolId = 946;

  public void serialize(ICustomDataOutput param1) {
    this.orientation.serializeAs_ActorOrientation(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.orientation = new ActorOrientation();
    this.orientation.deserialize(param1);
  }
}
