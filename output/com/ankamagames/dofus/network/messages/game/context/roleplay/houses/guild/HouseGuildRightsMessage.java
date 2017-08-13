package com.ankamagames.dofus.network.messages.game.context.roleplay.houses.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class HouseGuildRightsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5703;
    private boolean _isInitialized = false;
    private int houseId = 0;
    private int instanceId = 0;
    private boolean secondHand = false;
    private GuildInformations guildInfo;
    private int rights = 0;
    private FuncTree _guildInfotree;


    public void serialize(ICustomDataOutput param1) {
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element houseId.");
         }
         param1.writeVarInt(this.houseId);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeBoolean(this.secondHand);
         this.guildInfo.serializeAs_GuildInformations(param1);
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element rights.");
         }
         param1.writeVarInt(this.rights);
    }

    public void deserialize(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseGuildRightsMessage.houseId.");
         }
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseGuildRightsMessage.instanceId.");
         }
         this.secondHand = param1.readBoolean();
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of HouseGuildRightsMessage.rights.");
         }
    }

}