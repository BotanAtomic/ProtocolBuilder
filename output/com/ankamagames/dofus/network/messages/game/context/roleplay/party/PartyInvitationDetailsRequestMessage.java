package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyInvitationDetailsRequestMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 6264;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6264;
    }

    public PartyInvitationDetailsRequestMessage initPartyInvitationDetailsRequestMessage(int param1) {
         super.initAbstractPartyMessage(param1);
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
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
         this.serializeAs_PartyInvitationDetailsRequestMessage(param1);
    }

    public void serializeAs_PartyInvitationDetailsRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationDetailsRequestMessage(param1);
    }

    public void deserializeAs_PartyInvitationDetailsRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationDetailsRequestMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationDetailsRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}