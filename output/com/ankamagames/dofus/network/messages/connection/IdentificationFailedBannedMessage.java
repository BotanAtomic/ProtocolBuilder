package com.ankamagames.dofus.network.messages.connection;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class IdentificationFailedBannedMessage extends IdentificationFailedMessage implements INetworkMessage {

    private int protocolId = 6174;
    private boolean _isInitialized = false;
    private Number banEndDate = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6174;
    }

    public IdentificationFailedBannedMessage initIdentificationFailedBannedMessage(int param1,Number  param2) {
         super.initIdentificationFailedMessage(param1);
         this.banEndDate = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.banEndDate = 0;
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
         this.serializeAs_IdentificationFailedBannedMessage(param1);
    }

    public void serializeAs_IdentificationFailedBannedMessage(ICustomDataOutput param1) {
         super.serializeAs_IdentificationFailedMessage(param1);
         if(this.banEndDate < 0 || this.banEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.banEndDate + ") on element banEndDate.");
         }
         param1.writeDouble(this.banEndDate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentificationFailedBannedMessage(param1);
    }

    public void deserializeAs_IdentificationFailedBannedMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._banEndDateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentificationFailedBannedMessage(param1);
    }

    public void deserializeAsyncAs_IdentificationFailedBannedMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._banEndDateFunc);
    }

    private void _banEndDateFunc(ICustomDataInput param1) {
         this.banEndDate = param1.readDouble();
         if(this.banEndDate < 0 || this.banEndDate > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.banEndDate + ") on element of IdentificationFailedBannedMessage.banEndDate.");
         }
    }

}