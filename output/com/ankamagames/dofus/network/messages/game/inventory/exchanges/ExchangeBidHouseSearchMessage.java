package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeBidHouseSearchMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5806;
    private boolean _isInitialized = false;
    private int type = 0;
    private int genId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5806;
    }

    public ExchangeBidHouseSearchMessage initExchangeBidHouseSearchMessage(int param1,int  param2) {
         this.type = param1;
         this.genId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.type = 0;
         this.genId = 0;
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
         this.serializeAs_ExchangeBidHouseSearchMessage(param1);
    }

    public void serializeAs_ExchangeBidHouseSearchMessage(ICustomDataOutput param1) {
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element type.");
         }
         param1.writeVarInt(this.type);
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element genId.");
         }
         param1.writeVarShort(this.genId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeBidHouseSearchMessage(param1);
    }

    public void deserializeAs_ExchangeBidHouseSearchMessage(ICustomDataInput param1) {
         this._typeFunc(param1);
         this._genIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeBidHouseSearchMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeBidHouseSearchMessage(FuncTree param1) {
         param1.addChild(this._typeFunc);
         param1.addChild(this._genIdFunc);
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readVarUhInt();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of ExchangeBidHouseSearchMessage.type.");
         }
    }

    private void _genIdFunc(ICustomDataInput param1) {
         this.genId = param1.readVarUhShort();
         if(this.genId < 0)
         {
            throw new Exception("Forbidden value (" + this.genId + ") on element of ExchangeBidHouseSearchMessage.genId.");
         }
    }

}