package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItemNotInContainer;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeCraftResultMagicWithObjectDescMessage extends ExchangeCraftResultWithObjectDescMessage implements INetworkMessage {

    private int protocolId = 6188;
    private boolean _isInitialized = false;
    private int magicPoolStatus = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6188;
    }

    public ExchangeCraftResultMagicWithObjectDescMessage initExchangeCraftResultMagicWithObjectDescMessage(int param1,ObjectItemNotInContainer  param2,int  param3) {
         super.initExchangeCraftResultWithObjectDescMessage(param1,param2);
         this.magicPoolStatus = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.magicPoolStatus = 0;
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
         this.serializeAs_ExchangeCraftResultMagicWithObjectDescMessage(param1);
    }

    public void serializeAs_ExchangeCraftResultMagicWithObjectDescMessage(ICustomDataOutput param1) {
         super.serializeAs_ExchangeCraftResultWithObjectDescMessage(param1);
         param1.writeByte(this.magicPoolStatus);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCraftResultMagicWithObjectDescMessage(param1);
    }

    public void deserializeAs_ExchangeCraftResultMagicWithObjectDescMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._magicPoolStatusFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCraftResultMagicWithObjectDescMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCraftResultMagicWithObjectDescMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._magicPoolStatusFunc);
    }

    private void _magicPoolStatusFunc(ICustomDataInput param1) {
         this.magicPoolStatus = param1.readByte();
    }

}