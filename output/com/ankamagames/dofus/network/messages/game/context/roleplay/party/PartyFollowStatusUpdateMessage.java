package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;

public class PartyFollowStatusUpdateMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5581;
    private boolean _isInitialized = false;
    private boolean success = false;
    private boolean isFollowed = false;
    private Number followedId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5581;
    }

    public PartyFollowStatusUpdateMessage initPartyFollowStatusUpdateMessage(int param1,boolean  param2,boolean  param3,Number  param4) {
         super.initAbstractPartyMessage(param1);
         this.success = param2;
         this.isFollowed = param3;
         this.followedId = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.success = false;
         this.isFollowed = false;
         this.followedId = 0;
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
         this.serializeAs_PartyFollowStatusUpdateMessage(param1);
    }

    public void serializeAs_PartyFollowStatusUpdateMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.isFollowed);
         param1.writeByte(_loc2_);
         if(this.followedId < 0 || this.followedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.followedId + ") on element followedId.");
         }
         param1.writeVarLong(this.followedId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyFollowStatusUpdateMessage(param1);
    }

    public void deserializeAs_PartyFollowStatusUpdateMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.deserializeByteBoxes(param1);
         this._followedIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyFollowStatusUpdateMessage(param1);
    }

    public void deserializeAsyncAs_PartyFollowStatusUpdateMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._followedIdFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.isFollowed = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _followedIdFunc(ICustomDataInput param1) {
         this.followedId = param1.readVarUhLong();
         if(this.followedId < 0 || this.followedId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.followedId + ") on element of PartyFollowStatusUpdateMessage.followedId.");
         }
    }

}