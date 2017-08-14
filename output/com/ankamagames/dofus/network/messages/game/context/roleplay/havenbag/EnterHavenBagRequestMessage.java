package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class EnterHavenBagRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Number havenBagOwner = 0;
  public static final int protocolId = 6636;

  public void serialize(ICustomDataOutput param1) {
    if (this.havenBagOwner < 0 || this.havenBagOwner > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.havenBagOwner + ") on element havenBagOwner.");
    }
    param1.writeVarLong(this.havenBagOwner);
  }

  public void deserialize(ICustomDataInput param1) {
    this.havenBagOwner = param1.readVarUhLong();
    if (this.havenBagOwner < 0 || this.havenBagOwner > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.havenBagOwner
              + ") on element of EnterHavenBagRequestMessage.havenBagOwner.");
    }
  }
}
