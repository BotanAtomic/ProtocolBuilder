package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ExchangeMultiCraftCrafterCanUseHisRessourcesMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6020;
    private boolean _isInitialized = false;
    private boolean allowed = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6020;
    }

    public ExchangeMultiCraftCrafterCanUseHisRessourcesMessage initExchangeMultiCraftCrafterCanUseHisRessourcesMessage(boolean param1) {
         this.allowed = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.allowed = false;
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
         this.serializeAs_ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(param1);
    }

    public void serializeAs_ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.allowed);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(param1);
    }

    public void deserializeAs_ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(ICustomDataInput param1) {
         this._allowedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeMultiCraftCrafterCanUseHisRessourcesMessage(FuncTree param1) {
         param1.addChild(this._allowedFunc);
    }

    private void _allowedFunc(ICustomDataInput param1) {
         this.allowed = param1.readBoolean();
    }

}