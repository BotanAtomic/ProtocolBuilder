package com.ankamagames.dofus.network.messages.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameContextRefreshEntityLookMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number id = 0;
  public EntityLook look;
  private FuncTree _looktree;
  public static final int protocolId = 5637;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    this.look.serializeAs_EntityLook(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.look = new EntityLook();
    this.look.deserialize(param1);
  }
}
