package package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInvitationStateRecrutedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5548;
    private boolean _isInitialized = false;
    private int invitationState = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5548;
    }

    public GuildInvitationStateRecrutedMessage initGuildInvitationStateRecrutedMessage(int param1) {
         this.invitationState = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.invitationState = 0;
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
         this.serializeAs_GuildInvitationStateRecrutedMessage(param1);
    }

    public void serializeAs_GuildInvitationStateRecrutedMessage(ICustomDataOutput param1) {
         param1.writeByte(this.invitationState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInvitationStateRecrutedMessage(param1);
    }

    public void deserializeAs_GuildInvitationStateRecrutedMessage(ICustomDataInput param1) {
         this._invitationStateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInvitationStateRecrutedMessage(param1);
    }

    public void deserializeAsyncAs_GuildInvitationStateRecrutedMessage(FuncTree param1) {
         param1.addChild(this._invitationStateFunc);
    }

    private void _invitationStateFunc(ICustomDataInput param1) {
         this.invitationState = param1.readByte();
         if(this.invitationState < 0)
            throw new Exception("Forbidden value (" + this.invitationState + ") on element of GuildInvitationStateRecrutedMessage.invitationState.");
    }

}