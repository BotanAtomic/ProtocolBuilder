package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.GuildVersatileInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GuildVersatileInfoListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6435;
    private boolean _isInitialized = false;
    private Vector.<GuildVersatileInformations> guilds = ;
    private FuncTree _guildstree = ;
    private int _loc2_ = 0;
    private GuildVersatileInformations _loc5_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;
    private GuildVersatileInformations _loc3_ = ProtocolTypeManager.getInstance(GuildVersatileInformations,_loc2_);


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6435;
    }

    public GuildVersatileInfoListMessage initGuildVersatileInfoListMessage(Vector.<GuildVersatileInformations> param1) {
         this.guilds = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.guilds = new Vector.<GuildVersatileInformations>();
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
         this.serializeAs_GuildVersatileInfoListMessage(param1);
    }

    public void serializeAs_GuildVersatileInfoListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.guilds.length);
         int _loc2_ = 0;
         while(_loc2_ < this.guilds.length)
            param1.writeShort((this.guilds[_loc2_] as GuildVersatileInformations).getTypeId());
            (this.guilds[_loc2_] as GuildVersatileInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildVersatileInfoListMessage(param1);
    }

    public void deserializeAs_GuildVersatileInfoListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         GuildVersatileInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(GuildVersatileInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.guilds.push(_loc5_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildVersatileInfoListMessage(param1);
    }

    public void deserializeAsyncAs_GuildVersatileInfoListMessage(FuncTree param1) {
         this._guildstree = param1.addChild(this._guildstreeFunc);
    }

    private void _guildstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._guildstree.addChild(this._guildsFunc);
            _loc3_++;
    }

    private void _guildsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         GuildVersatileInformations _loc3_ = ProtocolTypeManager.getInstance(GuildVersatileInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.guilds.push(_loc3_);
    }

}