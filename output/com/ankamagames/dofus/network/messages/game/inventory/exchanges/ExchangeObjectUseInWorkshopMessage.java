package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeObjectUseInWorkshopMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6004;
    private boolean _isInitialized = false;
    private int objectUID = 0;
    private int quantity = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6004;
    }

    public ExchangeObjectUseInWorkshopMessage initExchangeObjectUseInWorkshopMessage(int param1,int  param2) {
         this.objectUID = param1;
         this.quantity = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.objectUID = 0;
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
         this.serializeAs_ExchangeObjectUseInWorkshopMessage(param1);
    }

    public void serializeAs_ExchangeObjectUseInWorkshopMessage(ICustomDataOutput param1) {
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element objectUID.");
         }
         param1.writeVarInt(this.objectUID);
         param1.writeVarInt(this.quantity);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeObjectUseInWorkshopMessage(param1);
    }

    public void deserializeAs_ExchangeObjectUseInWorkshopMessage(ICustomDataInput param1) {
         this._objectUIDFunc(param1);
         this._quantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeObjectUseInWorkshopMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeObjectUseInWorkshopMessage(FuncTree param1) {
         param1.addChild(this._objectUIDFunc);
         param1.addChild(this._quantityFunc);
    }

    private void _objectUIDFunc(ICustomDataInput param1) {
         this.objectUID = param1.readVarUhInt();
         if(this.objectUID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectUID + ") on element of ExchangeObjectUseInWorkshopMessage.objectUID.");
         }
    }

    private void _quantityFunc(ICustomDataInput param1) {
         this.quantity = param1.readVarInt();
    }

}