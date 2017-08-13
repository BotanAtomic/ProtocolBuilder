package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ExchangeCraftResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5790;
    private boolean _isInitialized = false;
    private int craftResult = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5790;
    }

    public ExchangeCraftResultMessage initExchangeCraftResultMessage(int param1) {
         this.craftResult = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.craftResult = 0;
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
         this.serializeAs_ExchangeCraftResultMessage(param1);
    }

    public void serializeAs_ExchangeCraftResultMessage(ICustomDataOutput param1) {
         param1.writeByte(this.craftResult);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftResultMessage(param1);
    }

    public void deserializeAs_ExchangeCraftResultMessage(ICustomDataInput param1) {
         this._craftResultFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftResultMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftResultMessage(FuncTree param1) {
         param1.addChild(this._craftResultFunc);
    }

    private void _craftResultFunc(ICustomDataInput param1) {
         this.craftResult = param1.readByte();
         if(this.craftResult < 0)
         {
            throw new Exception("Forbidden value (" + this.craftResult + ") on element of ExchangeCraftResultMessage.craftResult.");
         }
    }

}