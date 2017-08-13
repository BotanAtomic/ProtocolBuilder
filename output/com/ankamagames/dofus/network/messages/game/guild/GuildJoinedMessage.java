package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.GuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildJoinedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5564;
    private boolean _isInitialized = false;
    private GuildInformations guildInfo = ;
    private int memberRights = 0;
    private FuncTree _guildInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5564;
    }

    public GuildJoinedMessage initGuildJoinedMessage(GuildInformations param1,int  param2) {
         this.guildInfo = param1;
         this.memberRights = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
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
         this.serializeAs_GuildJoinedMessage(param1);
    }

    public void serializeAs_GuildJoinedMessage(ICustomDataOutput param1) {
         this.guildInfo.serializeAs_GuildInformations(param1);
         if(this.memberRights < 0)
            throw new Exception("Forbidden value (" + this.memberRights + ") on element memberRights.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildJoinedMessage(param1);
    }

    public void deserializeAs_GuildJoinedMessage(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserialize(param1);
         this._memberRightsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildJoinedMessage(param1);
    }

    public void deserializeAsyncAs_GuildJoinedMessage(FuncTree param1) {
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
         param1.addChild(this._memberRightsFunc);
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new GuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

    private void _memberRightsFunc(ICustomDataInput param1) {
         this.memberRights = param1.readVarUhInt();
         if(this.memberRights < 0)
            throw new Exception("Forbidden value (" + this.memberRights + ") on element of GuildJoinedMessage.memberRights.");
    }

}