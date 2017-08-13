package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyKickedByMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5590;
    private boolean _isInitialized = false;
    private Number kickerId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5590;
    }

    public PartyKickedByMessage initPartyKickedByMessage(int param1,Number  param2) {
         super.initAbstractPartyMessage(param1);
         this.kickerId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.kickerId = 0;
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
         this.serializeAs_PartyKickedByMessage(param1);
    }

    public void serializeAs_PartyKickedByMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         if(this.kickerId < 0 || this.kickerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kickerId + ") on element kickerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyKickedByMessage(param1);
    }

    public void deserializeAs_PartyKickedByMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._kickerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyKickedByMessage(param1);
    }

    public void deserializeAsyncAs_PartyKickedByMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._kickerIdFunc);
    }

    private void _kickerIdFunc(ICustomDataInput param1) {
         this.kickerId = param1.readVarUhLong();
         if(this.kickerId < 0 || this.kickerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.kickerId + ") on element of PartyKickedByMessage.kickerId.");
    }

}