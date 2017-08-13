package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.dofus.network.messages.game.inventory.exchanges.ExchangeObjectMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeObjectRemovedFromBagMessage extends ExchangeObjectMessage implements INetworkMessage {

    private int protocolId = 6010;
    private boolean _isInitialized = false;
    private int objectUID = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6010;
    }

    public ExchangeObjectRemovedFromBagMessage initExchangeObjectRemovedFromBagMessage(boolean param1,int  param2) {
         super.initExchangeObjectMessage(param1);
         this.objectUID = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.objectUID = 0;
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
         this.serializeAs_ExchangeObjectRemovedFromBagMessage(param1);
    }

    public void serializeAs_ExchangeObjectRemovedFromBagMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeObjectMessage(param1);
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectRemovedFromBagMessage(param1);
    }

    public void deserializeAs_ExchangeObjectRemovedFromBagMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._objectUIDFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectRemovedFromBagMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectRemovedFromBagMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._objectUIDFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ExchangeObjectRemovedFromBagMessage.objectUID.");
    }

}