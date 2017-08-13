package com.ankamagames.dofus.network.messages.game.inventory.items;

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

public class InventoryWeightMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3009;
    private boolean _isInitialized = false;
    private int weight = 0;
    private int weightMax = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 3009;
    }

    public InventoryWeightMessage initInventoryWeightMessage(int param1,int  param2) {
         this.weight = param1;
         this.weightMax = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.weight = 0;
         this.weightMax = 0;
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
         this.serializeAs_InventoryWeightMessage(param1);
    }

    public void serializeAs_InventoryWeightMessage(ICustomDataOutput param1) {
         if(this.weight < 0)
         {
            throw new Exception("Forbidden value (" + this.weight + ") on element weight.");
         }
         param1.writeVarInt(this.weight);
         if(this.weightMax < 0)
         {
            throw new Exception("Forbidden value (" + this.weightMax + ") on element weightMax.");
         }
         param1.writeVarInt(this.weightMax);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InventoryWeightMessage(param1);
    }

    public void deserializeAs_InventoryWeightMessage(ICustomDataInput param1) {
         this._weightFunc(param1);
         this._weightMaxFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InventoryWeightMessage(param1);
    }

    public void deserializeAsyncAs_InventoryWeightMessage(FuncTree param1) {
         param1.addChild(this._weightFunc);
         param1.addChild(this._weightMaxFunc);
    }

    private void _weightFunc(ICustomDataInput param1) {
         this.weight = param1.readVarUhInt();
         if(this.weight < 0)
         {
            throw new Exception("Forbidden value (" + this.weight + ") on element of InventoryWeightMessage.weight.");
         }
    }

    private void _weightMaxFunc(ICustomDataInput param1) {
         this.weightMax = param1.readVarUhInt();
         if(this.weightMax < 0)
         {
            throw new Exception("Forbidden value (" + this.weightMax + ") on element of InventoryWeightMessage.weightMax.");
         }
    }

}