package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ObtainedItemMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6519;
    private boolean _isInitialized = false;
    private int genericId = 0;
    private int baseQuantity = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6519;
    }

    public ObtainedItemMessage initObtainedItemMessage(int param1,int  param2) {
         this.genericId = param1;
         this.baseQuantity = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.genericId = 0;
         this.baseQuantity = 0;
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
         this.serializeAs_ObtainedItemMessage(param1);
    }

    public void serializeAs_ObtainedItemMessage(ICustomDataOutput param1) {
         if(this.genericId < 0)
            throw new Exception("Forbidden value (" + this.genericId + ") on element genericId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObtainedItemMessage(param1);
    }

    public void deserializeAs_ObtainedItemMessage(ICustomDataInput param1) {
         this._genericIdFunc(param1);
         this._baseQuantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObtainedItemMessage(param1);
    }

    public void deserializeAsyncAs_ObtainedItemMessage(FuncTree param1) {
         param1.addChild(this._genericIdFunc);
         param1.addChild(this._baseQuantityFunc);
    }

    private void _genericIdFunc(ICustomDataInput param1) {
         this.genericId = param1.readVarUhShort();
         if(this.genericId < 0)
            throw new Exception("Forbidden value (" + this.genericId + ") on element of ObtainedItemMessage.genericId.");
    }

    private void _baseQuantityFunc(ICustomDataInput param1) {
         this.baseQuantity = param1.readVarUhInt();
         if(this.baseQuantity < 0)
            throw new Exception("Forbidden value (" + this.baseQuantity + ") on element of ObtainedItemMessage.baseQuantity.");
    }

}