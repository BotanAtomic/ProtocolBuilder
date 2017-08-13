package com.ankamagames.dofus.network.messages.game.inventory.storage;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class StorageKamasUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5645;
    private boolean _isInitialized = false;
    private Number kamasTotal = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5645;
    }

    public StorageKamasUpdateMessage initStorageKamasUpdateMessage(Number param1) {
         this.kamasTotal = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.kamasTotal = 0;
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
         this.serializeAs_StorageKamasUpdateMessage(param1);
    }

    public void serializeAs_StorageKamasUpdateMessage(ICustomDataOutput param1) {
         if(this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamasTotal + ") on element kamasTotal.");
         }
         param1.writeVarLong(this.kamasTotal);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StorageKamasUpdateMessage(param1);
    }

    public void deserializeAs_StorageKamasUpdateMessage(ICustomDataInput param1) {
         this._kamasTotalFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StorageKamasUpdateMessage(param1);
    }

    public void deserializeAsyncAs_StorageKamasUpdateMessage(FuncTree param1) {
         param1.addChild(this._kamasTotalFunc);
    }

    private void _kamasTotalFunc(ICustomDataInput param1) {
         this.kamasTotal = param1.readVarUhLong();
         if(this.kamasTotal < 0 || this.kamasTotal > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.kamasTotal + ") on element of StorageKamasUpdateMessage.kamasTotal.");
         }
    }

}