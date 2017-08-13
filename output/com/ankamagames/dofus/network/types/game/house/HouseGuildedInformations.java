package com.ankamagames.dofus.network.types.game.house;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class HouseGuildedInformations extends HouseInstanceInformations implements INetworkType {

    private int protocolId = 512;
    private GuildInformations guildInfo;
    private FuncTree _guildInfotree;


    public void serialize(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.secondHand);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isLocked);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,2,this.isSaleLocked);
         param1.writeByte(_loc2_);
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element instanceId.");
         }
         param1.writeInt(this.instanceId);
         param1.writeUTF(this.ownerName);
         if(this.price < -9.007199254740992E15 || this.price > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.price + ") on element price.");
         }
         param1.writeVarLong(this.price);
         this.guildInfo.serializeAs_GuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HouseInstanceInformations(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
    }

}