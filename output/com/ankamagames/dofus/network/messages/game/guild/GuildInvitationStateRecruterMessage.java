package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GuildInvitationStateRecruterMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5563;
    private boolean _isInitialized = false;
    private String recrutedName = "";
    private int invitationState = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5563;
    }

    public GuildInvitationStateRecruterMessage initGuildInvitationStateRecruterMessage(String param1,int  param2) {
         this.recrutedName = param1;
         this.invitationState = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.recrutedName = "";
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
         this.serializeAs_GuildInvitationStateRecruterMessage(param1);
    }

    public void serializeAs_GuildInvitationStateRecruterMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.recrutedName);
         param1.writeByte(this.invitationState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInvitationStateRecruterMessage(param1);
    }

    public void deserializeAs_GuildInvitationStateRecruterMessage(ICustomDataInput param1) {
         this._recrutedNameFunc(param1);
         this._invitationStateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInvitationStateRecruterMessage(param1);
    }

    public void deserializeAsyncAs_GuildInvitationStateRecruterMessage(FuncTree param1) {
         param1.addChild(this._recrutedNameFunc);
         param1.addChild(this._invitationStateFunc);
    }

    private void _recrutedNameFunc(ICustomDataInput param1) {
         this.recrutedName = param1.readUTF();
    }

    private void _invitationStateFunc(ICustomDataInput param1) {
         this.invitationState = param1.readByte();
         if(this.invitationState < 0)
         {
            throw new Exception("Forbidden value (" + this.invitationState + ") on element of GuildInvitationStateRecruterMessage.invitationState.");
         }
    }

}