package package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ObtainedItemWithBonusMessage extends ObtainedItemMessage implements INetworkMessage {

    private int protocolId = 6520;
    private boolean _isInitialized = false;
    private int bonusQuantity = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6520;
    }

    public ObtainedItemWithBonusMessage initObtainedItemWithBonusMessage(int param1,int  param2,int  param3) {
         super.initObtainedItemMessage(param1,param2);
         this.bonusQuantity = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.bonusQuantity = 0;
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
         this.serializeAs_ObtainedItemWithBonusMessage(param1);
    }

    public void serializeAs_ObtainedItemWithBonusMessage(ICustomDataOutput param1) {
         super.serializeAs_ObtainedItemMessage(param1);
         if(this.bonusQuantity < 0)
            throw new Exception("Forbidden value (" + this.bonusQuantity + ") on element bonusQuantity.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ObtainedItemWithBonusMessage(param1);
    }

    public void deserializeAs_ObtainedItemWithBonusMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._bonusQuantityFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ObtainedItemWithBonusMessage(param1);
    }

    public void deserializeAsyncAs_ObtainedItemWithBonusMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._bonusQuantityFunc);
    }

    private void _bonusQuantityFunc(ICustomDataInput param1) {
         this.bonusQuantity = param1.readVarUhInt();
         if(this.bonusQuantity < 0)
            throw new Exception("Forbidden value (" + this.bonusQuantity + ") on element of ObtainedItemWithBonusMessage.bonusQuantity.");
    }

}