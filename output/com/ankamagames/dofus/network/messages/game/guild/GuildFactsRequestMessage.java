package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildFactsRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6404;
    private boolean _isInitialized = false;
    private int guildId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6404;
    }

    public GuildFactsRequestMessage initGuildFactsRequestMessage(int param1) {
         this.guildId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guildId = 0;
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
         this.serializeAs_GuildFactsRequestMessage(param1);
    }

    public void serializeAs_GuildFactsRequestMessage(ICustomDataOutput param1) {
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element guildId.");
         }
         param1.writeVarInt(this.guildId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFactsRequestMessage(param1);
    }

    public void deserializeAs_GuildFactsRequestMessage(ICustomDataInput param1) {
         this._guildIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFactsRequestMessage(param1);
    }

    public void deserializeAsyncAs_GuildFactsRequestMessage(FuncTree param1) {
         param1.addChild(this._guildIdFunc);
    }

    private void _guildIdFunc(ICustomDataInput param1) {
         this.guildId = param1.readVarUhInt();
         if(this.guildId < 0)
         {
            throw new Exception("Forbidden value (" + this.guildId + ") on element of GuildFactsRequestMessage.guildId.");
         }
    }

}