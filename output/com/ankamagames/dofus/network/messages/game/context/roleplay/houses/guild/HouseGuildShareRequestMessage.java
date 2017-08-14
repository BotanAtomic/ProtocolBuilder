package com.ankamagames.dofus.network.messages.game.context.roleplay.houses.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseGuildShareRequestMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int houseId = 0;
  public int instanceId = 0;
  public boolean enable = false;
  public int rights = 0;
  public static final int protocolId = 5704;

  public void serialize(ICustomDataOutput param1) {
    if (this.houseId < 0) {
      throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
    }
    param1.writeVarInt(this.houseId);
    if (this.instanceId < 0) {
      throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeBoolean(this.enable);
    if (this.rights < 0) {
      throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
    }
    param1.writeVarInt(this.rights);
  }

  public void deserialize(ICustomDataInput param1) {
    this.houseId = param1.readVarUhInt();
    if (this.houseId < 0) {
      throw new Exception(
          "Forbidden value (" + this.houseId + ") on element of HouseInformations.houseId.");
    }

    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Exception(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    int _loc2_ = param1.readByte();
    if (_loc2_ < 0) {
      throw new Exception("Forbidden value (" + _loc2_ + ") on elements of enable.");
    }
    this.enable.push(_loc2_);

    this.rights = param1.readVarUhInt();
    if (this.rights < 0) {
      throw new Exception(
          "Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
    }
  }
}
