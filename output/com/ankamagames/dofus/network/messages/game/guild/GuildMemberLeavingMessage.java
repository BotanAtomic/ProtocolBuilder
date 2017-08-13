package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildMemberLeavingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5923;
    private boolean _isInitialized = false;
    private boolean kicked = false;
    private Number memberId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5923;
    }

    public GuildMemberLeavingMessage initGuildMemberLeavingMessage(boolean param1,Number  param2) {
         this.kicked = param1;
         this.memberId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.kicked = false;
         this.memberId = 0;
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
         this.serializeAs_GuildMemberLeavingMessage(param1);
    }

    public void serializeAs_GuildMemberLeavingMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.kicked);
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element memberId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildMemberLeavingMessage(param1);
    }

    public void deserializeAs_GuildMemberLeavingMessage(ICustomDataInput param1) {
         this._kickedFunc(param1);
         this._memberIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildMemberLeavingMessage(param1);
    }

    public void deserializeAsyncAs_GuildMemberLeavingMessage(FuncTree param1) {
         param1.addChild(this._kickedFunc);
         param1.addChild(this._memberIdFunc);
    }

    private void _kickedFunc(ICustomDataInput param1) {
         this.kicked = param1.readBoolean();
    }

    private void _memberIdFunc(ICustomDataInput param1) {
         this.memberId = param1.readVarUhLong();
         if(this.memberId < 0 || this.memberId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.memberId + ") on element of GuildMemberLeavingMessage.memberId.");
    }

}