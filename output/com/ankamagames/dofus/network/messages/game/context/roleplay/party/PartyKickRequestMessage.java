package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyKickRequestMessage extends AbstractPartyMessage implements INetworkMessage {

    private int protocolId = 5592;
    private boolean _isInitialized = false;
    private Number playerId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 5592;
    }

    public PartyKickRequestMessage initPartyKickRequestMessage(int param1,Number  param2) {
         super.initAbstractPartyMessage(param1);
         this.playerId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.playerId = 0;
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
         this.serializeAs_PartyKickRequestMessage(param1);
    }

    public void serializeAs_PartyKickRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_AbstractPartyMessage(param1);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyKickRequestMessage(param1);
    }

    public void deserializeAs_PartyKickRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._playerIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyKickRequestMessage(param1);
    }

    public void deserializeAsyncAs_PartyKickRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._playerIdFunc);
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.playerId + ") on element of PartyKickRequestMessage.playerId.");
    }

}