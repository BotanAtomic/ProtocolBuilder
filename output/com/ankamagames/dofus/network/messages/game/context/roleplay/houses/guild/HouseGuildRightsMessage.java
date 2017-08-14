package com.ankamagames.dofus.network.messages.game.context.roleplay.houses.guild;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseGuildRightsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int houseId = 0;
  public int instanceId = 0;
  public boolean secondHand = false;
  public GuildInformations guildInfo;
  public int rights = 0;
  private FuncTree _guildInfotree;
  public static final int protocolId = 5703;

  public void serialize(ICustomDataOutput param1) {
    if (this.houseId < 0) {
      throw new Error("Forbidden value (" + this.houseId + ") on element houseId.");
    }
    param1.writeVarInt(this.houseId);
    if (this.instanceId < 0) {
      throw new Error("Forbidden value (" + this.instanceId + ") on element instanceId.");
    }
    param1.writeInt(this.instanceId);
    param1.writeBoolean(this.secondHand);
    this.guildInfo.serializeAs_GuildInformations(param1);
    if (this.rights < 0) {
      throw new Error("Forbidden value (" + this.rights + ") on element rights.");
    }
    param1.writeVarInt(this.rights);
  }

  public void deserialize(ICustomDataInput param1) {
    this.houseId = param1.readVarUhInt();
    if (this.houseId < 0) {
      throw new Error(
          "Forbidden value (" + this.houseId + ") on element of HouseInformations.houseId.");
    }

    this.instanceId = param1.readInt();
    if (this.instanceId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.instanceId
              + ") on element of HouseInstanceInformations.instanceId.");
    }

    this.secondHand = param1.readBoolean();

    this.guildInfo = new GuildInformations();
    this.guildInfo.deserialize(param1);
    this.rights = param1.readVarUhInt();
    if (this.rights < 0) {
      throw new Error("Forbidden value (" + this.rights + ") on element of GuildMember.rights.");
    }
  }
}
