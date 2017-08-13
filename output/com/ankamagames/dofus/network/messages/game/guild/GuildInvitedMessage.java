package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.BasicGuildInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildInvitedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5552;
    private boolean _isInitialized = false;
    private Number recruterId = 0;
    private String recruterName = "";
    private BasicGuildInformations guildInfo;
    private FuncTree _guildInfotree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5552;
    }

    public GuildInvitedMessage initGuildInvitedMessage(Number param1,String  param2,BasicGuildInformations  param3) {
         this.recruterId = param1;
         this.recruterName = param2;
         this.guildInfo = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.recruterId = 0;
         this.recruterName = "";
         this.guildInfo = new BasicGuildInformations();
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
         this.serializeAs_GuildInvitedMessage(param1);
    }

    public void serializeAs_GuildInvitedMessage(ICustomDataOutput param1) {
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.recruterId + ") on element recruterId.");
         }
         param1.writeVarLong(this.recruterId);
         param1.writeUTF(this.recruterName);
         this.guildInfo.serializeAs_BasicGuildInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInvitedMessage(param1);
    }

    public void deserializeAs_GuildInvitedMessage(ICustomDataInput param1) {
         this._recruterIdFunc(param1);
         this._recruterNameFunc(param1);
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInvitedMessage(param1);
    }

    public void deserializeAsyncAs_GuildInvitedMessage(FuncTree param1) {
         param1.addChild(this._recruterIdFunc);
         param1.addChild(this._recruterNameFunc);
         this._guildInfotree = param1.addChild(this._guildInfotreeFunc);
    }

    private void _recruterIdFunc(ICustomDataInput param1) {
         this.recruterId = param1.readVarUhLong();
         if(this.recruterId < 0 || this.recruterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.recruterId + ") on element of GuildInvitedMessage.recruterId.");
         }
    }

    private void _recruterNameFunc(ICustomDataInput param1) {
         this.recruterName = param1.readUTF();
    }

    private void _guildInfotreeFunc(ICustomDataInput param1) {
         this.guildInfo = new BasicGuildInformations();
         this.guildInfo.deserializeAsync(this._guildInfotree);
    }

}