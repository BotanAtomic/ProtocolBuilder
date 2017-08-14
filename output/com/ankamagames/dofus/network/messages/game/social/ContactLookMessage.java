package com.ankamagames.dofus.network.messages.game.social;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ContactLookMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int requestId = 0;
  public String playerName = "";
  public Number playerId = 0;
  public EntityLook look;
  private FuncTree _looktree;
  public static final int protocolId = 5934;

  public void serialize(ICustomDataOutput param1) {
    if (this.requestId < 0) {
      throw new Error("Forbidden value (" + this.requestId + ") on element requestId.");
    }
    param1.writeVarInt(this.requestId);
    param1.writeUTF(this.playerName);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    this.look.serializeAs_EntityLook(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.requestId = param1.readUnsignedByte();
    if (this.requestId < 0 || this.requestId > 255) {
      throw new Error(
          "Forbidden value ("
              + this.requestId
              + ") on element of ContactLookRequestMessage.requestId.");
    }

    this.playerName = param1.readUTF();

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    this.look = new EntityLook();
    this.look.deserialize(param1);
  }
}
