package com.ankamagames.dofus.network.messages.game.character.status;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PlayerStatusUpdateMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int accountId = 0;
  public Number playerId = 0;
  public PlayerStatus status;
  private FuncTree _statustree;
  public static final int protocolId = 6386;

  public void serialize(ICustomDataOutput param1) {
    if (this.accountId < 0) {
      throw new Error("Forbidden value (" + this.accountId + ") on element accountId.");
    }
    param1.writeInt(this.accountId);
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.playerId + ") on element playerId.");
    }
    param1.writeVarLong(this.playerId);
    param1.writeShort(this.status.getTypeId());
    this.status.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    this.accountId = param1.readInt();
    if (this.accountId < 0) {
      throw new Error(
          "Forbidden value (" + this.accountId + ") on element of GuildMember.accountId.");
    }

    this.playerId = param1.readVarUhLong();
    if (this.playerId < 0 || this.playerId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.playerId + ") on element of TaxCollectorMovement.playerId.");
    }

    int _loc2_ = param1.readUnsignedShort();
    this.status = ProtocolTypeManager.getInstance(PlayerStatus, _loc2_);
    this.status.deserialize(param1);
  }
}
