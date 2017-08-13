package package com.ankamagames.dofus.network.messages.game.context.roleplay.party.companion;

import com.ankamagames.dofus.network.messages.game.context.roleplay.party.PartyUpdateLightMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyCompanionUpdateLightMessage extends PartyUpdateLightMessage implements INetworkMessage {

    private int protocolId = 6472;
    private boolean _isInitialized = false;
    private int indexId = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6472;
    }

    public PartyCompanionUpdateLightMessage initPartyCompanionUpdateLightMessage(int param1,Number  param2,int  param3,int  param4,int  param5,int  param6,int  param7) {
         super.initPartyUpdateLightMessage(param1,param2,param3,param4,param5,param6);
         this.indexId = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.indexId = 0;
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
         this.serializeAs_PartyCompanionUpdateLightMessage(param1);
    }

    public void serializeAs_PartyCompanionUpdateLightMessage(ICustomDataOutput param1) {
         super.serializeAs_PartyUpdateLightMessage(param1);
         if(this.indexId < 0)
            throw new Exception("Forbidden value (" + this.indexId + ") on element indexId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyCompanionUpdateLightMessage(param1);
    }

    public void deserializeAs_PartyCompanionUpdateLightMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._indexIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyCompanionUpdateLightMessage(param1);
    }

    public void deserializeAsyncAs_PartyCompanionUpdateLightMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._indexIdFunc);
    }

    private void _indexIdFunc(ICustomDataInput param1) {
         this.indexId = param1.readByte();
         if(this.indexId < 0)
            throw new Exception("Forbidden value (" + this.indexId + ") on element of PartyCompanionUpdateLightMessage.indexId.");
    }

}