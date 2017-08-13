package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildModificationEmblemValidMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6328;
    private boolean _isInitialized = false;
    private GuildEmblem guildEmblem = ;
    private FuncTree _guildEmblemtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6328;
    }

    public GuildModificationEmblemValidMessage initGuildModificationEmblemValidMessage(GuildEmblem param1) {
         this.guildEmblem = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guildEmblem = new GuildEmblem();
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
         this.serializeAs_GuildModificationEmblemValidMessage(param1);
    }

    public void serializeAs_GuildModificationEmblemValidMessage(ICustomDataOutput param1) {
         this.guildEmblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildModificationEmblemValidMessage(param1);
    }

    public void deserializeAs_GuildModificationEmblemValidMessage(ICustomDataInput param1) {
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildModificationEmblemValidMessage(param1);
    }

    public void deserializeAsyncAs_GuildModificationEmblemValidMessage(FuncTree param1) {
         this._guildEmblemtree = param1.addChild(this._guildEmblemtreeFunc);
    }

    private void _guildEmblemtreeFunc(ICustomDataInput param1) {
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserializeAsync(this._guildEmblemtree);
    }

}