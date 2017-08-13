package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AllianceMembershipMessage extends AllianceJoinedMessage implements INetworkMessage {

    private int protocolId = 6390;
    private boolean _isInitialized = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6390;
    }

    public AllianceMembershipMessage initAllianceMembershipMessage(AllianceInformations param1,boolean  param2,int  param3) {
         super.initAllianceJoinedMessage(param1,param2,param3);
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
         this.serializeAs_AllianceMembershipMessage(param1);
    }

    public void serializeAs_AllianceMembershipMessage(ICustomDataOutput param1) {
         super.serializeAs_AllianceJoinedMessage(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceMembershipMessage(param1);
    }

    public void deserializeAs_AllianceMembershipMessage(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceMembershipMessage(param1);
    }

    public void deserializeAsyncAs_AllianceMembershipMessage(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}