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

public class ExchangeStartOkMulticraftCustomerMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5817;
    private boolean _isInitialized = false;
    private int skillId = 0;
    private int crafterJobLevel = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5817;
    }

    public ExchangeStartOkMulticraftCustomerMessage initExchangeStartOkMulticraftCustomerMessage(int param1,int  param2) {
         this.skillId = param1;
         this.crafterJobLevel = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.skillId = 0;
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
         this.serializeAs_ExchangeStartOkMulticraftCustomerMessage(param1);
    }

    public void serializeAs_ExchangeStartOkMulticraftCustomerMessage(ICustomDataOutput param1) {
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element skillId.");
         }
         param1.writeVarInt(this.skillId);
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element crafterJobLevel.");
         }
         param1.writeByte(this.crafterJobLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ExchangeStartOkMulticraftCustomerMessage(param1);
    }

    public void deserializeAs_ExchangeStartOkMulticraftCustomerMessage(ICustomDataInput param1) {
         this._skillIdFunc(param1);
         this._crafterJobLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ExchangeStartOkMulticraftCustomerMessage(param1);
    }

    public void deserializeAsyncAs_ExchangeStartOkMulticraftCustomerMessage(FuncTree param1) {
         param1.addChild(this._skillIdFunc);
         param1.addChild(this._crafterJobLevelFunc);
    }

    private void _skillIdFunc(ICustomDataInput param1) {
         this.skillId = param1.readVarUhInt();
         if(this.skillId < 0)
         {
            throw new Exception("Forbidden value (" + this.skillId + ") on element of ExchangeStartOkMulticraftCustomerMessage.skillId.");
         }
    }

    private void _crafterJobLevelFunc(ICustomDataInput param1) {
         this.crafterJobLevel = param1.readUnsignedByte();
         if(this.crafterJobLevel < 0 || this.crafterJobLevel > 255)
         {
            throw new Exception("Forbidden value (" + this.crafterJobLevel + ") on element of ExchangeStartOkMulticraftCustomerMessage.crafterJobLevel.");
         }
    }

}