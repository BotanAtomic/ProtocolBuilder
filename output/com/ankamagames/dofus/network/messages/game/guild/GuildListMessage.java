package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6413;
    private boolean _isInitialized = false;
    private Vector<GuildInformations> guilds;
    private FuncTree _guildstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6413;
    }

    public GuildListMessage initGuildListMessage(Vector<GuildInformations> param1) {
         this.guilds = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guilds = new Vector.<GuildInformations>();
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
         this.serializeAs_GuildListMessage(param1);
    }

    public void serializeAs_GuildListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.guilds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.guilds.length)
         {
            (this.guilds[_loc2_] as GuildInformations).serializeAs_GuildInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildListMessage(param1);
    }

    public void deserializeAs_GuildListMessage(ICustomDataInput param1) {
         GuildInformations _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GuildInformations();
            _loc4_.deserialize(param1);
            this.guilds.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildListMessage(param1);
    }

    public void deserializeAsyncAs_GuildListMessage(FuncTree param1) {
         this._guildstree = param1.addChild(this._guildstreeFunc);
    }

    private void _guildstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._guildstree.addChild(this._guildsFunc);
            _loc3_++;
         }
    }

    private void _guildsFunc(ICustomDataInput param1) {
         GuildInformations _loc2_ = new GuildInformations();
         _loc2_.deserialize(param1);
         this.guilds.push(_loc2_);
    }

}