package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TeleportHavenBagAnswerMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public boolean accept = false;
  public static final int protocolId = 6646;

  public void serialize(ICustomDataOutput param1) {
    param1.writeBoolean(this.accept);
  }

  public void deserialize(ICustomDataInput param1) {
    this.accept = param1.readBoolean();
  }
}
