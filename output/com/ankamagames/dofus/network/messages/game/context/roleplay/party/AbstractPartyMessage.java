package package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractPartyMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6274;
    private boolean _isInitialized = false;
    private int partyId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6274;
    }

    public AbstractPartyMessage initAbstractPartyMessage(int param1) {
         this.partyId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.partyId = 0;
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
         this.serializeAs_AbstractPartyMessage(param1);
    }

    public void serializeAs_AbstractPartyMessage(ICustomDataOutput param1) {
         if(this.partyId < 0)
            throw new Exception("Forbidden value (" + this.partyId + ") on element partyId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPartyMessage(param1);
    }

    public void deserializeAs_AbstractPartyMessage(ICustomDataInput param1) {
         this._partyIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractPartyMessage(param1);
    }

    public void deserializeAsyncAs_AbstractPartyMessage(FuncTree param1) {
         param1.addChild(this._partyIdFunc);
    }

    private void _partyIdFunc(ICustomDataInput param1) {
         this.partyId = param1.readVarUhInt();
         if(this.partyId < 0)
            throw new Exception("Forbidden value (" + this.partyId + ") on element of AbstractPartyMessage.partyId.");
    }

}