package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildMemberOnlineStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6061;
    private boolean _isInitialized = false;
    private Number memberId = 0;
    private boolean online = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6061;
    }

    public GuildMemberOnlineStatusMessage initGuildMemberOnlineStatusMessage(Number param1,boolean  param2) {
         this.memberId = param1;
         this.online = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.memberId = 0;
         this.online = false;
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
         this.serializeAs_GuildMemberOnlineStatusMessage(param1);
    }

    public void serializeAs_GuildMemberOnlineStatusMessage(ICustomDataOutput param1) {
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildMemberOnlineStatusMessage(param1);
    }

    public void deserializeAs_GuildMemberOnlineStatusMessage(ICustomDataInput param1) {
         this._memberIdFunc(param1);
         this._onlineFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildMemberOnlineStatusMessage(param1);
    }

    public void deserializeAsyncAs_GuildMemberOnlineStatusMessage(FuncTree param1) {
         param1.addChild(this._memberIdFunc);
         param1.addChild(this._onlineFunc);
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element of GuildMemberOnlineStatusMessage.memberId.");
    }

    private void _onlineFunc(ICustomDataInput param1) {
         this.online = param1.readBoolean();
    }

}