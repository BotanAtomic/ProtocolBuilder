package package com.ankamagames.dofus.network.messages.game.inventory.exchanges;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ExchangeCrafterJobLevelupMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6598;
    private boolean _isInitialized = false;
    private int crafterJobLevel = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6598;
    }

    public ExchangeCrafterJobLevelupMessage initExchangeCrafterJobLevelupMessage(int param1) {
         this.crafterJobLevel = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.crafterJobLevel = 0;
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
         this.serializeAs_ExchangeCrafterJobLevelupMessage(param1);
    }

    public void serializeAs_ExchangeCrafterJobLevelupMessage(ICustomDataOutput param1) {
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element crafterJobLevel.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeCrafterJobLevelupMessage(param1);
    }

    public void deserializeAs_ExchangeCrafterJobLevelupMessage(ICustomDataInput param1) {
         this._crafterJobLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeCrafterJobLevelupMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeCrafterJobLevelupMessage(FuncTree param1) {
         param1.addChild(this._crafterJobLevelFunc);
    }

    private void _crafterJobLevelFunc(ICustomDataInput param1) {
         this.crafterJobLevel = param1.readUnsignedByte();
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element of ExchangeCrafterJobLevelupMessage.crafterJobLevel.");
    }

}