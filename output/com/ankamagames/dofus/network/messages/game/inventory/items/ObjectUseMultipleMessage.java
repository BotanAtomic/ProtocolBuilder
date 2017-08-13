package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObjectUseMultipleMessage extends ObjectUseMessage implements INetworkMessage {

    private int protocolId = 6234;
    private boolean _isInitialized = false;
    private int quantity = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6234;
    }

    public ObjectUseMultipleMessage initObjectUseMultipleMessage(int param1,int  param2) {
         super.initObjectUseMessage(param1);
         this.quantity = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.quantity = 0;
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
         this.serializeAs_ObjectUseMultipleMessage(param1);
    }

    public void serializeAs_ObjectUseMultipleMessage(ICustomDataOutput param1) {
         super.serializeAs_ObjectUseMessage(param1);
         if(this.quantity < 0)
            throw new Exception("Forbidden value (" + this.quantity + ") on element quantity.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObjectUseMultipleMessage(param1);
    }

    public void deserializeAs_ObjectUseMultipleMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObjectUseMultipleMessage(param1);
    }

    public void deserializeAsyncAs_ObjectUseMultipleMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._quantityFunc);
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarUhInt();
         if(this.quantity < 0)
            throw new Exception("Forbidden value (" + this.quantity + ") on element of ObjectUseMultipleMessage.quantity.");
    }

}