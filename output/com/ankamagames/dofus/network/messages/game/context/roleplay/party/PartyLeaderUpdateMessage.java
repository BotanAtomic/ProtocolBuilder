package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyLeaderUpdateMessage extends AbstractPartyEventMessage implements INetworkMessage {

    private int protocolId = 5578;
    private boolean _isInitialized = false;
    private Number partyLeaderId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5578;
    }

    public PartyLeaderUpdateMessage initPartyLeaderUpdateMessage(int param1,Number  param2) {
         super.initAbstractPartyEventMessage(param1);
         this.partyLeaderId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.partyLeaderId = 0;
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
         this.serializeAs_PartyLeaderUpdateMessage(param1);
    }

    public void serializeAs_PartyLeaderUpdateMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyEventMessage(param1);
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element partyLeaderId.");
         }
         param1.writeVarLong(this.partyLeaderId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyLeaderUpdateMessage(param1);
    }

    public void deserializeAs_PartyLeaderUpdateMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._partyLeaderIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyLeaderUpdateMessage(param1);
    }

    public void deserializeAsyncAs_PartyLeaderUpdateMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._partyLeaderIdFunc);
    }

    private void _partyLeaderIdFunc(ICustomDataInput param1) {
         this.partyLeaderId = param1.readVarUhLong();
         if(this.partyLeaderId < 0 || this.partyLeaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.partyLeaderId + ") on element of PartyLeaderUpdateMessage.partyLeaderId.");
         }
    }

}