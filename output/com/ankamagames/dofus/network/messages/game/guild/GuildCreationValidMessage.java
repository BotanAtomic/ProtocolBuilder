package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildEmblem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildCreationValidMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5546;
    private boolean _isInitialized = false;
    private String guildName = "";
    private GuildEmblem guildEmblem = ;
    private FuncTree _guildEmblemtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5546;
    }

    public GuildCreationValidMessage initGuildCreationValidMessage(String param1,GuildEmblem  param2) {
         this.guildName = param1;
         this.guildEmblem = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guildName = "";
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
         this.serializeAs_GuildCreationValidMessage(param1);
    }

    public void serializeAs_GuildCreationValidMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.guildName);
         this.guildEmblem.serializeAs_GuildEmblem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildCreationValidMessage(param1);
    }

    public void deserializeAs_GuildCreationValidMessage(ICustomDataInput param1) {
         this._guildNameFunc(param1);
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildCreationValidMessage(param1);
    }

    public void deserializeAsyncAs_GuildCreationValidMessage(FuncTree param1) {
         param1.addChild(this._guildNameFunc);
         this._guildEmblemtree = param1.addChild(this._guildEmblemtreeFunc);
    }

    private void _guildNameFunc(ICustomDataInput param1) {
         this.guildName = param1.readUTF();
    }

    private void _guildEmblemtreeFunc(ICustomDataInput param1) {
         this.guildEmblem = new GuildEmblem();
         this.guildEmblem.deserializeAsync(this._guildEmblemtree);
    }

}