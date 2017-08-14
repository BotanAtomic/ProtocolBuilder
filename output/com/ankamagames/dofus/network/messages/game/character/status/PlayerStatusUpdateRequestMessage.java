package com.ankamagames.dofus.network.messages.game.character.status;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.status.PlayerStatus;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class PlayerStatusUpdateRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public PlayerStatus status;
  private FuncTree _statustree;
  public static final int protocolId = 6387;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.status.getTypeId());
    this.status.serialize(param1);
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc2_ = param1.readUnsignedShort();
    this.status = ProtocolTypeManager.getInstance(PlayerStatus, _loc2_);
    this.status.deserialize(param1);
  }
}
