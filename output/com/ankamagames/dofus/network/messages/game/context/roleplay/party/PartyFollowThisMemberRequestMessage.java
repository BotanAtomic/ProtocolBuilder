package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class PartyFollowThisMemberRequestMessage extends PartyFollowMemberRequestMessage implements INetworkMessage {

    private int protocolId = 5588;
    private boolean _isInitialized = false;
    private boolean enabled = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5588;
    }

    public PartyFollowThisMemberRequestMessage initPartyFollowThisMemberRequestMessage(int param1,Number  param2,boolean  param3) {
         super.initPartyFollowMemberRequestMessage(param1,param2);
         this.enabled = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.enabled = false;
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
         this.serializeAs_PartyFollowThisMemberRequestMessage(param1);
    }

    public void serializeAs_PartyFollowThisMemberRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_PartyFollowMemberRequestMessage(param1);
         param1.writeBoolean(this.enabled);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyFollowThisMemberRequestMessage(param1);
    }

    public void deserializeAs_PartyFollowThisMemberRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._enabledFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyFollowThisMemberRequestMessage(param1);
    }

    public void deserializeAsyncAs_PartyFollowThisMemberRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._enabledFunc);
    }

    private void _enabledFunc(ICustomDataInput param1) {
         this.enabled = param1.readBoolean();
    }

}