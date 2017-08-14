package com.ankamagames.dofus.network.messages.game.look;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AccessoryPreviewMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public EntityLook look;
  private FuncTree _looktree;
  public static final int protocolId = 6517;

  public void serialize(ICustomDataOutput param1) {
    this.look.serializeAs_EntityLook(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.look = new EntityLook();
    this.look.deserialize(param1);
  }
}
