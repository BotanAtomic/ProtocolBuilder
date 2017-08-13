package com.ankamagames.dofus.network.messages.game.context.roleplay.houses.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
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


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5703;
    }

    public HouseGuildRightsMessage initHouseGuildRightsMessage(int param1,int  param2,boolean  param3,GuildInformations  param4,int  param5) {
         this.houseId = param1;
         this.instanceId = param2;
         this.secondHand = param3;
         this.guildInfo = param4;
         this.rights = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.houseId = 0;
         this.instanceId = 0;
         this.secondHand = false;
         this.guildInfo = new GuildInformations();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HouseGuildRightsMessage(param1);
    }

    public void serializeAs_HouseGuildRightsMessage(ICustomDataOutput param1) {
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
         this.deserializeAs_HouseGuildRightsMessage(param1);
    }

    public void deserializeAs_HouseGuildRightsMessage(ICustomDataInput param1) {
         this._houseIdFunc(param1);
         this._instanceIdFunc(param1);
         this._secondHandFunc(param1);
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this._rightsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HouseGuildRightsMessage(param1);
    }

    public void deserializeAsyncAs_HouseGuildRightsMessage(FuncTree param1) {
         param1.addChild(this._houseIdFunc);
         param1.addChild(this._instanceIdFunc);
         param1.addChild(this._secondHandFunc);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
         param1.addChild(this._rightsFunc);
    }

    private void _houseIdFunc(ICustomDataInput param1) {
         this.houseId = param1.readVarUhInt();
         if(this.houseId < 0)
         {
            throw new Exception("Forbidden value (" + this.houseId + ") on element of HouseGuildRightsMessage.houseId.");
         }
    }

    private void _instanceIdFunc(ICustomDataInput param1) {
         this.instanceId = param1.readInt();
         if(this.instanceId < 0)
         {
            throw new Exception("Forbidden value (" + this.instanceId + ") on element of HouseGuildRightsMessage.instanceId.");
         }
    }

    private void _secondHandFunc(ICustomDataInput param1) {
         this.secondHand = param1.readBoolean();
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

    private void _rightsFunc(ICustomDataInput param1) {
         this.rights = param1.readVarUhInt();
         if(this.rights < 0)
         {
            throw new Exception("Forbidden value (" + this.rights + ") on element of HouseGuildRightsMessage.rights.");
         }
    }

}